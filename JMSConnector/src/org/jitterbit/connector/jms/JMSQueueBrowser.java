package org.jitterbit.connector.jms;

import java.util.Enumeration;
import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.message.ConnectorMessage;
import org.jitterbit.connector.jms.pojo.message.CustomMessageProperty;
import org.jitterbit.connector.jms.pojo.message.CustomMessagePropertyList;
import org.jitterbit.connector.jms.pojo.message.MessageHeaders;
import org.jitterbit.connector.jms.pojo.message.MessageList;
import org.jitterbit.connector.jms.pojo.queueBrowser.QueueBrowserActivityMetadata;
import org.jitterbit.connector.jms.pojo.queueBrowser.QueueBrowserRequest;
import org.jitterbit.connector.jms.pojo.queueBrowser.QueueBrowserResponse;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageActivityMetadata;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageRequest;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageResponse;

public class JMSQueueBrowser {
	Connection conn;
	
	public JMSQueueBrowser(Connection conn){
		this.conn = conn;
	}
	
	QueueBrowserResponse browseMessages(QueueBrowserRequest browserReq, Queue queue) {
		QueueBrowserResponse browserRes = new QueueBrowserResponse();
		
		QueueBrowserActivityMetadata browserActMetadata =browserReq.getQueueBrowserActivityMetadata();
		try{
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueBrowser queueBrowser=session.createBrowser(queue);
			MessageList msgList = new MessageList();
			List<ConnectorMessage> connMessages =msgList.getMessage();
			conn.start();
			Enumeration enumMsg = queueBrowser.getEnumeration();
	        int counter = 0;
	        while (enumMsg.hasMoreElements()) {
	            Message jmsMsg = (Message) enumMsg.nextElement();
				ConnectorMessage connMsg = new ConnectorMessage();
				MessageHeaders msgHeaders = new MessageHeaders();
				CustomMessagePropertyList customMessagePropertyList = new CustomMessagePropertyList();
				JMSUtil.constructConnectorMessageHeaders(jmsMsg, msgHeaders);
				JMSUtil.constructConnectorMessageProperties(jmsMsg, customMessagePropertyList );
				JMSUtil.constructConnectorMessageCustomProperties(jmsMsg, customMessagePropertyList );
					  
				connMsg.setMessageHeaders(msgHeaders);
				connMsg.setCustomMessageProperties(customMessagePropertyList);
	//			connMsg.setMessageBody(jmsMsg.);
				connMessages.add(connMsg);
	            counter += 1;
	        }
	        
	        browserRes.setNumberOfMessages(counter);
	        browserRes.setActivityName(JMSConstants.ACTIVITY_RECEIVE_MESSAGE);
			browserRes.setActivityType(JMSConstants.DEDICATED_API_CALL);
			browserRes.setDirection("output");
			browserRes.setParentAppDomain("General");
			browserRes.setSchema(msgList);
		}catch(JMSException je1){
			je1.printStackTrace();
		}
		return browserRes;
		
	}

}
