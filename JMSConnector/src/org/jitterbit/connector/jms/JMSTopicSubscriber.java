package org.jitterbit.connector.jms;

import java.util.Enumeration;
import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.message.ConnectorMessage;
import org.jitterbit.connector.jms.pojo.message.CustomMessageProperty;
import org.jitterbit.connector.jms.pojo.message.CustomMessagePropertyList;
import org.jitterbit.connector.jms.pojo.message.MessageHeaders;
import org.jitterbit.connector.jms.pojo.message.MessageList;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageActivityMetadata;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageRequest;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageResponse;
import org.jitterbit.connector.jms.pojo.subscribeMessage.SubscribeMessageActivityMetadata;
import org.jitterbit.connector.jms.pojo.subscribeMessage.SubscribeMessageRequest;
import org.jitterbit.connector.jms.pojo.subscribeMessage.SubscribeMessageResponse;

public class JMSTopicSubscriber {
	Connection conn;
	public JMSTopicSubscriber(Connection conn){
		this.conn = conn;
		
	}
	
	SubscribeMessageResponse subscribeMessages(SubscribeMessageRequest subscribeMsgReq, Topic topic) {
		SubscribeMessageResponse subscribeMsgRes = new SubscribeMessageResponse();
		
		SubscribeMessageActivityMetadata subscribeMsgActMetadata =subscribeMsgReq.getSubscribeMessageActivityMetadata();
		String msgType =subscribeMsgActMetadata.getMessageType();
		String msgSelector = subscribeMsgActMetadata.getMessageSelector();
		long timeout = subscribeMsgActMetadata.getReceiveTimeout();
		String durableSubName=subscribeMsgActMetadata.getDurableSubscriptionName();
		String clientID = subscribeMsgActMetadata.getClientID();
		MessageConsumer topicSubscriber = null;

		Session session = null;
		try{
		if(subscribeMsgActMetadata.isDurableSubscription()){
			conn.setClientID(clientID);
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			topicSubscriber  = session.createDurableSubscriber(topic, durableSubName, msgSelector, false);
		}else{
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			topicSubscriber =session.createConsumer(topic, msgSelector);
		}
		
		MessageList msgList = new MessageList();
		List<ConnectorMessage> connMessages =msgList.getMessage();
		conn.start();
		
		
		while (true) {
			//as this is a synchronous call, the consumer waits for messages only till the specified timeout period
			//and then returns
			Message jmsMsg = topicSubscriber.receive(timeout);
			String text=null;
			if (jmsMsg != null) {
				if(msgType.equalsIgnoreCase(JMSConstants.MESSAGE_TYPE_TEXT)){
				    if (jmsMsg instanceof TextMessage) {
				      text= ((TextMessage) jmsMsg ).getText();
				    }else { //control msg received, commit transaction
				    	session.commit(); // acknowledge all
				    	break;
				    }
				}else if(msgType.equalsIgnoreCase(JMSConstants.MESSAGE_TYPE_BYTE)){
					if(jmsMsg  instanceof BytesMessage){
				    	byte[] body = new byte[(int) ((BytesMessage) jmsMsg).getBodyLength()];
			            ((BytesMessage) jmsMsg).readBytes(body);
			            text = new String(body);
					}else { //control msg received, commit transaction
				    	session.commit(); // acknowledge all
				    	break;
				    }
				}
				ConnectorMessage connMsg = new ConnectorMessage();
				MessageHeaders msgHeaders = new MessageHeaders();
				CustomMessagePropertyList customMessagePropertyList = new CustomMessagePropertyList();
				JMSUtil.constructConnectorMessageHeaders(jmsMsg, msgHeaders);
				JMSUtil.constructConnectorMessageProperties(jmsMsg, customMessagePropertyList );
				JMSUtil.constructConnectorMessageCustomProperties(jmsMsg, customMessagePropertyList );
				  
				connMsg.setMessageHeaders(msgHeaders);
				connMsg.setCustomMessageProperties(customMessagePropertyList);
				connMsg.setMessageBody(text);
				connMessages.add(connMsg);
				     
			  }
			}
				
		subscribeMsgRes.setActivityName(JMSConstants.ACTIVITY_SUBSCRIBE_MESSAGE);
		subscribeMsgRes.setActivityType(JMSConstants.DEDICATED_API_CALL);
		subscribeMsgRes.setDirection("output");
		subscribeMsgRes.setParentAppDomain("General");
		subscribeMsgRes.setSchema(msgList);
		}catch(JMSException je1){
			je1.printStackTrace();
			try {
				session.rollback();
			} catch (JMSException je2) {
				je2.printStackTrace();
			}
		}
		return subscribeMsgRes;
		
	}
}
