package org.jitterbit.connector.jms;

import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
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
import org.jitterbit.connector.jms.pojo.publishMessage.PublishMessageMetadata;
import org.jitterbit.connector.jms.pojo.publishMessage.PublishMessageRequest;
import org.jitterbit.connector.jms.pojo.publishMessage.PublishMessageResponse;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageMetadata;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageRequest;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageResponse;



public class JMSTopicPublisher {
	Connection conn;
	public JMSTopicPublisher(Connection conn){
		this.conn = conn;
	}
	
	PublishMessageResponse publishMessages(PublishMessageRequest pubMsgReq, Topic topic1) {
		PublishMessageResponse pubMsgRes = new PublishMessageResponse();
		
		int count = 0;
		PublishMessageMetadata pubMsgActMetadata =pubMsgReq.getPublishMessageActivityMetadata();
		
		System.out.println(pubMsgActMetadata.getTopicName());
		Session session =null;
		try{
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Topic topic =session.createTopic(pubMsgActMetadata.getTopicName());
			MessageProducer topicPub =session.createProducer(topic);
			topicPub.setDeliveryMode(pubMsgActMetadata.getDeliveryMode());
			topicPub.setPriority(pubMsgActMetadata.getPriority());
			topicPub.setTimeToLive(pubMsgActMetadata.getTimeToLive());
			
			
			MessageList msgList= pubMsgReq.getMessageList();
			List<ConnectorMessage> connMessages=msgList.getMessage();
			conn.start();
			
			for(ConnectorMessage connMessage : connMessages){
				Message jmsMsg =null; 
		
				if(pubMsgActMetadata.getMessageType().value().equalsIgnoreCase(JMSConstants.MESSAGE_TYPE_TEXT)){
					TextMessage textMsg = session.createTextMessage(connMessage.getMessageBody());
					textMsg .setText(connMessage.getMessageBody());
				}else if(pubMsgActMetadata.getMessageType().value().equalsIgnoreCase(JMSConstants.MESSAGE_TYPE_BYTE)){
					BytesMessage byteMessage = session.createBytesMessage();
					byteMessage.writeBytes(connMessage.getMessageBody().getBytes());
					jmsMsg = byteMessage;
				}
				jmsMsg.setJMSDestination(topic);
				MessageHeaders msgHeaders =connMessage.getMessageHeaders();
				CustomMessagePropertyList customMessagePropertyList =connMessage.getCustomMessageProperties();
				
				JMSUtil.constructMessageHeaders(jmsMsg,msgHeaders,topic);
				JMSUtil.constructMessageProperties(jmsMsg,customMessagePropertyList );
				
				topicPub.send(jmsMsg);
				count++;
			}
			
			//TODO
	  		//get confirmation--a control message at the end to indicate the 'end of messages'? 
			topicPub.send(session.createMessage());
	
			//commit the send (actually put messages on queue)
			session.commit();
	
			pubMsgRes.setActivityName(JMSConstants.ACTIVITY_PUBLISH_MESSAGE);
			pubMsgRes.setActivityType(JMSConstants.DEDICATED_API_CALL);
			pubMsgRes.setDirection("output");
			pubMsgRes.setParentAppDomain("General");
			pubMsgRes.setSchema(count + "messages were sent in this transaction. No response exepected as PublishMessage is an asynchronous call");
		}catch(JMSException je1){
			je1.printStackTrace();
			try {
				session.rollback();
			} catch (JMSException je2) {
				je2.printStackTrace();
			}
		}
		return pubMsgRes;
	}
	
}
