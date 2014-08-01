package org.jitterbit.connector.jms;

import java.util.ArrayList;
import java.util.List;

import org.jitterbit.connector.dao.DummyConnectionDTO;
import org.jitterbit.connector.framework.pojo.execute.ExecuteRequest;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;
import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.message.ConnectorMessage;
import org.jitterbit.connector.jms.pojo.message.CustomMessageProperty;
import org.jitterbit.connector.jms.pojo.message.CustomMessagePropertyList;
import org.jitterbit.connector.jms.pojo.message.MessageHeaders;
import org.jitterbit.connector.jms.pojo.message.MessageList;
import org.jitterbit.connector.jms.pojo.sendMessage.MessageType;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageMetadata;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageRequest;

public class JmsConnectorTest {
	
	public static void main(String args[]){
		JMSConnector jmsCnctr = new JMSConnector();
		JmsConnectorTest jmscnctrTest = new JmsConnectorTest();
		jmscnctrTest.test(jmsCnctr);
		
	}
	
	public void test(JMSConnector jmsCnctr){
		
		jmsCnctr.createConnection();
		ExecuteRequest executeReq = new ExecuteRequest();
		SendMessageRequest sendMsgReq = new SendMessageRequest();
		
		DummyConnectionDTO connDTO = new DummyConnectionDTO();
		
		//ActivityMetadataRequest actMetaDataReq =  executeReq.getActivityMetadataRequest();
		ActivityMetadataRequest actMetaDataReq = new ActivityMetadataRequest();
		actMetaDataReq.setActivityName("Send Message");
		actMetaDataReq.setApplicationDomain("Connector");
		actMetaDataReq.setDirection("output");
		
		executeReq.setActivityName(JMSConstants.ACTIVITY_SEND_MESSAGE);
		//executeReq.setActivityMetadataRequest(actMetaDataReq);
		
		//SendMessageMetadata sendMsgMetaData = sendMsgReq.getSendMessageActivityMetadata();
		
		SendMessageMetadata sendMsgMetaData = new SendMessageMetadata();
		sendMsgMetaData.setDeliveryMode(1);
		sendMsgMetaData.setMessageType(MessageType.TEXT);
		sendMsgMetaData.setPriority(1);
		sendMsgMetaData.setQueueName("SendQueue");
		sendMsgMetaData.setTimeToLive(200000);
		
		//MessageList msgList = sendMsgReq.getMessageList();
		MessageList msgList = new MessageList();
		//List<ConnectorMessage> cnctrMessageList = msgList.getMessage();
		
		List<ConnectorMessage> cnctrMessageList = new ArrayList<ConnectorMessage>();
		MessageHeaders msgHeadrs = new MessageHeaders();
		msgHeadrs.setJMSCorrelationID("12345");
		msgHeadrs.setJMSDeliveryMode(1);
		msgHeadrs.setJMSDestination("SendQueue");
		msgHeadrs.setJMSExpiration(200000);
		msgHeadrs.setJMSMessageID("jms:12345");
		msgHeadrs.setJMSPriority(1);
		msgHeadrs.setJMSRedelivered(true);
		msgHeadrs.setJMSTimestamp(212121212);
		msgHeadrs.setJMSType("TEXT");
		
		ConnectorMessage cnctrMessage = new ConnectorMessage();
		cnctrMessage.setMessageBody("OK111111111111");
		cnctrMessage.setMessageHeaders(msgHeadrs);
		
		CustomMessagePropertyList customMsgPrp = new CustomMessagePropertyList();
		customMsgPrp.setName("abc");
		customMsgPrp.setValue("123");
		
		List<CustomMessageProperty> customMsgPrpList = new ArrayList<CustomMessageProperty>();
		CustomMessageProperty customMsgPrp1 = new CustomMessageProperty();		
		customMsgPrp1.setName("Key");
		customMsgPrp1.setValue("321");
		
		customMsgPrpList.add(customMsgPrp1);
		customMsgPrp.getCustomMessageProperty().addAll(customMsgPrpList);
		cnctrMessage.setCustomMessageProperties(customMsgPrp);
		cnctrMessageList.add(cnctrMessage);		
		msgList.getMessage().addAll(cnctrMessageList);
		
		sendMsgReq.setActivityName(actMetaDataReq.getActivityName());
		sendMsgReq.setApplicationDomain(actMetaDataReq.getApplicationDomain());
		sendMsgReq.setDirection(actMetaDataReq.getDirection());
		
		sendMsgReq.setMessageList(msgList);
		sendMsgReq.setSendMessageActivityMetadata(sendMsgMetaData);
		
		executeReq.setActivityMetadataRequest(sendMsgReq);
			
		jmsCnctr.execute(executeReq);
	
	}
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	


}
