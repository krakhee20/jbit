package org.jitterbit.connector.jms;

import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.message.ConnectorMessage;
import org.jitterbit.connector.jms.pojo.message.CustomMessagePropertyList;
import org.jitterbit.connector.jms.pojo.message.MessageHeaders;
import org.jitterbit.connector.jms.pojo.message.MessageList;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageActivityMetadata;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageRequest;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageResponse;

public class JMSQueueReceiver {
	Connection conn;
	
	public JMSQueueReceiver(Connection conn){
		this.conn = conn;
	}
	
	ReceiveMessageResponse receiveMessages(ReceiveMessageRequest receiveMsgReq, Queue queue1) {
		ReceiveMessageResponse receiveMsgRes = new ReceiveMessageResponse();
		
		ReceiveMessageActivityMetadata receiveMsgActMetadata =receiveMsgReq.getReceiveMessageActivityMetadata();
		String msgType =receiveMsgActMetadata.getMessageType();
		String msgSelector = receiveMsgActMetadata.getMessageSelector();
		long timeout = receiveMsgActMetadata.getReceiveTimeout();
		Session session =null;
		try{
			session= conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Queue queue =session.createQueue(receiveMsgActMetadata.getQueueName());
			MessageConsumer queueReceiver =session.createConsumer(queue, msgSelector);
			MessageList msgList = new MessageList();
			List<ConnectorMessage> connMessages =msgList.getMessage();
			conn.start();
			
			
			while (true) {
				//as this is a synchronous call, the consumer waits for messages only till the specified timeout period
				//and then returns
				Message jmsMsg = queueReceiver.receive(timeout);
				if (jmsMsg != null) {
					String text=null;
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
				}//end of while
					
	
			receiveMsgRes.setActivityName(JMSConstants.ACTIVITY_RECEIVE_MESSAGE);
			receiveMsgRes.setActivityType(JMSConstants.DEDICATED_API_CALL);
			receiveMsgRes.setDirection("output");
			receiveMsgRes.setParentAppDomain("General");
			receiveMsgRes.setSchema(msgList);
		}catch(JMSException je1){
			if(session != null)
				try {
					session.rollback();
				} catch (JMSException je2) {
					je2.printStackTrace();
				}
			
			je1.printStackTrace();
			
		}
		return receiveMsgRes;
		
	}

}
