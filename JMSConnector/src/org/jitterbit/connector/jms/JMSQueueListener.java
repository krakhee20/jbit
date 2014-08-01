package org.jitterbit.connector.jms;

import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.listenMessage.ListenMessageActivityMetadata;
import org.jitterbit.connector.jms.pojo.listenMessage.ListenMessageRequest;
import org.jitterbit.connector.jms.pojo.listenMessage.ListenMessageResponse;
import org.jitterbit.connector.jms.pojo.message.ConnectorMessage;
import org.jitterbit.connector.jms.pojo.message.CustomMessagePropertyList;
import org.jitterbit.connector.jms.pojo.message.MessageHeaders;
import org.jitterbit.connector.jms.pojo.message.MessageList;

public class JMSQueueListener implements MessageListener, ExceptionListener{
	Connection conn;
	Session session;
	String msgType ;
	List<ConnectorMessage> connMessages ;
	
	public JMSQueueListener(Connection conn){
		this.conn = conn;
	}
	
	ListenMessageResponse listenMessages(ListenMessageRequest listenMsgReq, Queue queue1) throws Exception{
		ListenMessageResponse listenMsgRes = new ListenMessageResponse();
		
		ListenMessageActivityMetadata listenMsgActMetadata =listenMsgReq.getListenMessageActivityMetadata();
		msgType =listenMsgActMetadata.getMessageType();
		String msgSelector = listenMsgActMetadata.getMessageSelector();
		
		session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue queue =session.createQueue(listenMsgActMetadata.getQueueName());
		MessageConsumer asyncReceiver =session.createConsumer(queue, msgSelector);
		asyncReceiver.setMessageListener(this);
		conn.setExceptionListener(this);
		
		MessageList msgList = new MessageList();
		connMessages =msgList.getMessage();
		conn.start();
		
		
		listenMsgRes.setActivityName(JMSConstants.ACTIVITY_RECEIVE_MESSAGE);
		listenMsgRes.setActivityType(JMSConstants.DEDICATED_API_CALL);
		listenMsgRes.setDirection("output");
		listenMsgRes.setParentAppDomain("General");
		listenMsgRes.setSchema(msgList);
		return listenMsgRes;
		
	}


	@Override
	public void onMessage(Message jmsMsg) {
		try{
			String text = null;
		    if (jmsMsg instanceof TextMessage) {
		    	text = ((TextMessage) jmsMsg).getText();
			      
		    }else if(jmsMsg instanceof BytesMessage){
		    	byte[] body = new byte[(int) ((BytesMessage) jmsMsg).getBodyLength()];
	            ((BytesMessage) jmsMsg).readBytes(body);
	            text = new String(body);
	        }else{//control message
	        	session.commit(); // acknowledge all        	
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
	    
		}catch(JMSException je1){
			je1.printStackTrace();
			try {
				session.rollback();
			} catch (JMSException je2) {
				je2.printStackTrace();
			}
		}
	}

	@Override
	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub
		
	}
}
