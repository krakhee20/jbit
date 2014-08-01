package org.jitterbit.connector.jms;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
import org.jitterbit.connector.jms.pojo.pollMessage.PollMessageActivityMetadata;
import org.jitterbit.connector.jms.pojo.pollMessage.PollMessageRequest;
import org.jitterbit.connector.jms.pojo.pollMessage.PollMessageResponse;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageActivityMetadata;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageRequest;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageResponse;

public class JMSQueuePoller extends TimerTask{
	Connection conn;
	MessageConsumer queuePoller;
	String msgType ;
	Session session;
	MessageList msgList = new MessageList();

	public JMSQueuePoller(Connection conn){
		this.conn = conn;
	}
	
	PollMessageResponse pollMessages(PollMessageRequest pollMsgReq, Queue queue1) throws Exception{
		PollMessageResponse pollMsgRes = new PollMessageResponse();
		
		PollMessageActivityMetadata pollMsgActMetadata =pollMsgReq.getPollMessageActivityMetadata();
		msgType =pollMsgActMetadata.getMessageType();
		String msgSelector = pollMsgActMetadata.getMessageSelector();
		long pollingInterval = pollMsgActMetadata.getPollingInterval();

		Session session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Queue queue =session.createQueue(pollMsgActMetadata.getQueueName());
		queuePoller =session.createConsumer(queue, msgSelector);
		conn.start();

		Timer timer = new Timer();
		timer.schedule(this, pollingInterval);

		pollMsgRes.setActivityName(JMSConstants.ACTIVITY_RECEIVE_MESSAGE);
		pollMsgRes.setActivityType(JMSConstants.DEDICATED_API_CALL);
		pollMsgRes.setDirection("output");
		pollMsgRes.setParentAppDomain("General");
		pollMsgRes.setSchema(msgList);
		return pollMsgRes;
		
	}

	@Override
	public void run() {
		msgList = new MessageList();
		List<ConnectorMessage> connMessages =msgList.getMessage();

		while (true) {
			Message jmsMsg;
			try {
				jmsMsg = queuePoller.receiveNoWait();
				String text = null;
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
				     
				}else
					break;
			}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}			  
		}//end of while		
		
	}

}
