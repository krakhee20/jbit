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

import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.message.ConnectorMessage;
import org.jitterbit.connector.jms.pojo.message.CustomMessageProperty;
import org.jitterbit.connector.jms.pojo.message.CustomMessagePropertyList;
import org.jitterbit.connector.jms.pojo.message.MessageHeaders;
import org.jitterbit.connector.jms.pojo.message.MessageList;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageMetadata;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageRequest;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageResponse;



public class JMSQueueSender {
	Connection conn;
	public JMSQueueSender(Connection conn){
		this.conn = conn;
	}
	
	SendMessageResponse sendMessages(SendMessageRequest sendMsgReq, Queue queue1) {
		SendMessageResponse sendMsgRes = new SendMessageResponse();
		
		int count = 0;
		SendMessageMetadata sendMsgActMetadata =sendMsgReq.getSendMessageActivityMetadata();
		
		System.out.println(sendMsgActMetadata.getQueueName());
		Session session =null;
		try{
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			Queue queue =session.createQueue(sendMsgActMetadata.getQueueName());
			MessageProducer queueSender =session.createProducer(queue1);
			queueSender.setDeliveryMode(sendMsgActMetadata.getDeliveryMode());
			queueSender.setPriority(sendMsgActMetadata.getPriority());
			queueSender.setTimeToLive(sendMsgActMetadata.getTimeToLive());
			
			MessageList msgList= sendMsgReq.getMessageList();
			List<ConnectorMessage> connMessages=msgList.getMessage();
			
			for(ConnectorMessage connMessage : connMessages){
				Message jmsMsg =null; 
		
				if(sendMsgActMetadata.getMessageType().value().equalsIgnoreCase(JMSConstants.MESSAGE_TYPE_TEXT)){
					TextMessage textMsg = session.createTextMessage(connMessage.getMessageBody());
					textMsg .setText(connMessage.getMessageBody());
				}else if(sendMsgActMetadata.getMessageType().value().equalsIgnoreCase(JMSConstants.MESSAGE_TYPE_BYTE)){
					BytesMessage byteMessage = session.createBytesMessage();
					byteMessage.writeBytes(connMessage.getMessageBody().getBytes());
					jmsMsg = byteMessage;
				}
				jmsMsg.setJMSDestination(queue);
				MessageHeaders msgHeaders =connMessage.getMessageHeaders();
				CustomMessagePropertyList customMessagePropertyList =connMessage.getCustomMessageProperties();
				JMSUtil.constructMessageHeaders(jmsMsg,msgHeaders,queue);
				JMSUtil.constructMessageProperties(jmsMsg,customMessagePropertyList );
				queueSender.send(jmsMsg);
				count++;
			}
			
			//TODO
	  		//get confirmation--a control message at the end to indicate the 'end of messages'? 
			queueSender.send(session.createMessage());
		
	
			//commit the send (actually put messages on queue)
			session.commit();
	
			sendMsgRes.setActivityName(JMSConstants.ACTIVITY_SEND_MESSAGE);
			sendMsgRes.setActivityType(JMSConstants.DEDICATED_API_CALL);
			sendMsgRes.setDirection("output");
			sendMsgRes.setParentAppDomain("General");
			sendMsgRes.setSchema(count + "messages were sent in this transaction. No response exepected as SendMessage as an asynchronous call");
		}catch(JMSException je1){
			je1.printStackTrace();
			if(session != null)
				try {
					session.rollback();
				} catch (JMSException je2) {
					je2.printStackTrace();
				}
		}
		return sendMsgRes;
	}
	
}
