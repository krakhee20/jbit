package org.jitterbit.connector.jms;

import java.util.Hashtable;
import java.util.Timer;

import javax.jms.Connection;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.jitterbit.connector.dao.DummyConnectionDTO;
import org.jitterbit.connector.framework.pojo.execute.ExecuteRequest;
import org.jitterbit.connector.framework.pojo.execute.ExecuteResponse;
import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.listenMessage.ListenMessageRequest;
import org.jitterbit.connector.jms.pojo.listenMessage.ListenMessageResponse;
import org.jitterbit.connector.jms.pojo.pollMessage.PollMessageRequest;
import org.jitterbit.connector.jms.pojo.pollMessage.PollMessageResponse;
import org.jitterbit.connector.jms.pojo.publishMessage.PublishMessageRequest;
import org.jitterbit.connector.jms.pojo.publishMessage.PublishMessageResponse;
import org.jitterbit.connector.jms.pojo.queueBrowser.QueueBrowserRequest;
import org.jitterbit.connector.jms.pojo.queueBrowser.QueueBrowserResponse;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageRequest;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageResponse;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageRequest;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageResponse;
import org.jitterbit.connector.jms.pojo.subscribeMessage.SubscribeMessageRequest;
import org.jitterbit.connector.jms.pojo.subscribeMessage.SubscribeMessageResponse;
import org.jitterbit.connector.jms.sessionmgmt.SessionManagerImpl;

public class JMSConnector {
	private SessionManagerImpl sessionMgr;
	private DummyConnectionDTO connDTO;
	
	Connection conn;
	Session session;
	

	public JMSConnector(){
		connDTO = new DummyConnectionDTO();
		sessionMgr = new SessionManagerImpl(connDTO);
	}

	Hashtable<String,String> constructCredentialsMap(){
		Hashtable<String,String> env = new Hashtable<String,String>();
		// Store the environment variable that tell JNDI which initial context
        // to use and where to find the provider.
        env.put(JMSConstants.JNDI_FACTORY_INITIAL, connDTO.getJNDI_FACTORY_INITIAL());
        env.put(JMSConstants.JNDI_PROVIDER_URL, connDTO.getJNDI_PROVIDER_URL());
        env.put(JMSConstants.JNDI_SECURITY_CREDENTIALS, connDTO.getJNDI_SECURITY_CREDENTIALS());
        env.put(JMSConstants.JNDI_SECURITY_PRINCIPAL, connDTO.getJNDI_SECURITY_PRINCIPAL());
        env.put(JMSConstants.JNDI_JMSJCA_QUEUE_CF, connDTO.getJNDI_JMSJCA_QUEUE_CF());
        env.put(JMSConstants.JNDI_JMSJCA_TOPIC_CF, connDTO.getJNDI_JMSJCA_TOPIC_CF());
        env.put("connectionFactory", "ConnectionFactory");
		return env;
	}
	
	public boolean createConnection(){
		Hashtable<String,String> env =	constructCredentialsMap();
		
		try {
			JMSProviderClassLoader.addFile("F:\\connector\\jmsprovider\\activemq-all-5.9.1.jar");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			sessionMgr.setInitialContext(env);
			conn = sessionMgr.createConnection(env);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	
	}
	
	public ExecuteResponse execute(ExecuteRequest executeRequestStructure){
		ExecuteResponse executeResponse = new ExecuteResponse();
		
		String activityName = executeRequestStructure.getActivityName();
		try{
			if(activityName.equalsIgnoreCase(JMSConstants.ACTIVITY_SEND_MESSAGE)){
				invokeJmsQueueSender(executeRequestStructure);	
			}else if(activityName.equalsIgnoreCase(JMSConstants.ACTIVITY_RECEIVE_MESSAGE)){
				invokeJmsQueueReceiver(executeRequestStructure);	
			}else if(activityName.equalsIgnoreCase(JMSConstants.ACTIVITY_LISTEN_MESSAGE)){
				this.invokeJmsQueueListener(executeRequestStructure);
			}else if(activityName.equalsIgnoreCase(JMSConstants.ACTIVITY_POLL_MESSAGE)){
				this.invokeJmsQueuePoller(executeRequestStructure);
			}else if(activityName.equalsIgnoreCase(JMSConstants.ACTIVITY_PUBLISH_MESSAGE)){
				this.invokeJmsTopicPublisher(executeRequestStructure);
			}else if(activityName.equalsIgnoreCase(JMSConstants.ACTIVITY_SUBSCRIBE_MESSAGE)){
				this.invokeJmsTopicSubscriber(executeRequestStructure);
			}else if(activityName.equalsIgnoreCase(JMSConstants.ACTIVITY_QUEUE_BROWSER)){
				this.invokeJmsQueueBrowser(executeRequestStructure);
			}
	
			sessionMgr.closeConnection(conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				sessionMgr.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return executeResponse;
		
	}
	
	ExecuteResponse invokeJmsQueueSender(ExecuteRequest executeRequestStructure) throws Exception{
		ExecuteResponse executeResponse = new ExecuteResponse();
		
		JMSQueueSender queueSender = new JMSQueueSender(conn);
		
		if( !((executeRequestStructure.getActivityMetadataRequest()) instanceof SendMessageRequest)){
			throw new Exception("Invalid request structure ");
		}else{
			SendMessageRequest sendMsgReq = (SendMessageRequest)executeRequestStructure.getActivityMetadataRequest();
		
			String queueName=sendMsgReq.getSendMessageActivityMetadata().getQueueName();
			System.out.println("queueName "+queueName );
			
			String providerClassName = connDTO.getJNDI_FACTORY_INITIAL();
			//TODO
			//Queue queue = JMSUtil.getReferenceToQueue(providerClassName, queueName);
			Queue queue = null;
			//Queue queue = (Queue) sessionMgr.getInitialContext().lookup(sendMsgReq.getSendMessageActivityMetadata().getQueueName());
			SendMessageResponse sendMessageResponse = queueSender.sendMessages(sendMsgReq, queue );
	
			executeResponse.setActivityName(JMSConstants.ACTIVITY_SEND_MESSAGE);
			executeResponse.setActivityMetadataResponse(sendMessageResponse);
			
		}
		return executeResponse;
	}

	ExecuteResponse invokeJmsTopicSubscriber(ExecuteRequest executeRequestStructure) throws Exception{
		ExecuteResponse executeResponse = new ExecuteResponse();
		
		JMSTopicSubscriber topicSub = new JMSTopicSubscriber(conn);
		
		if( !((executeRequestStructure.getActivityMetadataRequest()) instanceof SubscribeMessageRequest)){
			throw new Exception("Invalid request structure ");
		}else{
			SubscribeMessageRequest subMsgReq = (SubscribeMessageRequest)executeRequestStructure.getActivityMetadataRequest();
		
			String topicName =subMsgReq.getSubscribeMessageActivityMetadata().getTopicName();
			System.out.println("topicName "+topicName );
			
			String providerClassName = connDTO.getJNDI_FACTORY_INITIAL();
			//TODO
			//Queue queue = JMSUtil.getReferenceToQueue(providerClassName, queueName);
			Topic topic= null;
			//Queue queue = (Queue) sessionMgr.getInitialContext().lookup(sendMsgReq.getSendMessageActivityMetadata().getQueueName());
			SubscribeMessageResponse subMessageResponse = topicSub.subscribeMessages(subMsgReq, topic);
	
			executeResponse.setActivityName(JMSConstants.ACTIVITY_SEND_MESSAGE);
			executeResponse.setActivityMetadataResponse(subMessageResponse);
			
		}
		return executeResponse;
	}

	ExecuteResponse invokeJmsQueueBrowser(ExecuteRequest executeRequestStructure) throws Exception{
		ExecuteResponse executeResponse = new ExecuteResponse();
		
		JMSQueueBrowser browser = new JMSQueueBrowser(conn);
		
		if( !((executeRequestStructure.getActivityMetadataRequest()) instanceof QueueBrowserRequest)){
			throw new Exception("Invalid request structure ");
		}else{
			QueueBrowserRequest browserReq = (QueueBrowserRequest)executeRequestStructure.getActivityMetadataRequest();
		
			String queueName =browserReq.getQueueBrowserActivityMetadata().getQueueName();
			System.out.println("topicName "+queueName);
			
			String providerClassName = connDTO.getJNDI_FACTORY_INITIAL();
			//TODO
			//Queue queue = JMSUtil.getReferenceToQueue(providerClassName, queueName);
			Queue queue= null;
			//Queue queue = (Queue) sessionMgr.getInitialContext().lookup(sendMsgReq.getSendMessageActivityMetadata().getQueueName());
			QueueBrowserResponse browserResponse = browser.browseMessages(browserReq, queue);
	
			executeResponse.setActivityName(JMSConstants.ACTIVITY_SEND_MESSAGE);
			executeResponse.setActivityMetadataResponse(browserResponse);
			
		}
		return executeResponse;
	}

	ExecuteResponse invokeJmsQueueReceiver(ExecuteRequest executeRequestStructure) throws Exception {
		ExecuteResponse executeResponse = new ExecuteResponse();

		JMSQueueReceiver queueReceiver = new JMSQueueReceiver(conn);

		if( !((executeRequestStructure.getActivityMetadataRequest()) instanceof ReceiveMessageRequest)){
			throw new Exception("Invalid request structure ");
		}else{
			ReceiveMessageRequest receiveMsgReq = (ReceiveMessageRequest )executeRequestStructure.getActivityMetadataRequest();
		
			String queueName=receiveMsgReq.getReceiveMessageActivityMetadata().getQueueName();
			System.out.println("queueName "+queueName );
			
			String providerClassName = connDTO.getJNDI_FACTORY_INITIAL();
			//Queue queue = JMSUtil.getReferenceToQueue(providerClassName, queueName);
			Queue queue = null;
			//Queue queue = (Queue) sessionMgr.getInitialContext().lookup(sendMsgReq.getSendMessageActivityMetadata().getQueueName());
			ReceiveMessageResponse receiveMsgRes = queueReceiver.receiveMessages(receiveMsgReq, queue);
	
			executeResponse.setActivityName(JMSConstants.ACTIVITY_RECEIVE_MESSAGE);
			executeResponse.setActivityMetadataResponse(receiveMsgRes);
			return executeResponse;
		}
	}

	ExecuteResponse invokeJmsQueuePoller(ExecuteRequest executeRequestStructure) throws Exception {
		ExecuteResponse executeResponse = new ExecuteResponse();

		JMSQueuePoller queuePoller = new JMSQueuePoller(conn);

		if( !((executeRequestStructure.getActivityMetadataRequest()) instanceof PollMessageRequest)){
			throw new Exception("Invalid request structure ");
		}else{
			PollMessageRequest pollMsgReq = (PollMessageRequest )executeRequestStructure.getActivityMetadataRequest();
		
			String queueName=pollMsgReq.getPollMessageActivityMetadata().getQueueName();
			System.out.println("queueName "+queueName );
			long pollingInterval = pollMsgReq.getPollMessageActivityMetadata().getPollingInterval();
			
			String providerClassName = connDTO.getJNDI_FACTORY_INITIAL();
			//Queue queue = JMSUtil.getReferenceToQueue(providerClassName, queueName);
			Queue queue = null;
			//Queue queue = (Queue) sessionMgr.getInitialContext().lookup(sendMsgReq.getSendMessageActivityMetadata().getQueueName());
			PollMessageResponse pollMsgRes = queuePoller.pollMessages(pollMsgReq, queue);
	
			executeResponse.setActivityName(JMSConstants.ACTIVITY_RECEIVE_MESSAGE);
			executeResponse.setActivityMetadataResponse(pollMsgRes);
			return executeResponse;
		}
	}

	ExecuteResponse invokeJmsQueueListener(ExecuteRequest executeRequestStructure) throws Exception {
		ExecuteResponse executeResponse = new ExecuteResponse();

		JMSQueueListener queueListener = new JMSQueueListener(conn);

		if( !((executeRequestStructure.getActivityMetadataRequest()) instanceof ListenMessageRequest)){
			throw new Exception("Invalid request structure ");
		}else{
			ListenMessageRequest pollMsgReq = (ListenMessageRequest )executeRequestStructure.getActivityMetadataRequest();
		
			String queueName=pollMsgReq.getListenMessageActivityMetadata().getQueueName();
			System.out.println("queueName "+queueName );
			
			String providerClassName = connDTO.getJNDI_FACTORY_INITIAL();
			//Queue queue = JMSUtil.getReferenceToQueue(providerClassName, queueName);
			Queue queue = null;
			//Queue queue = (Queue) sessionMgr.getInitialContext().lookup(sendMsgReq.getSendMessageActivityMetadata().getQueueName());
			ListenMessageResponse pollMsgRes = queueListener.listenMessages(pollMsgReq, queue);
			
	
			executeResponse.setActivityName(JMSConstants.ACTIVITY_LISTEN_MESSAGE);
			executeResponse.setActivityMetadataResponse(pollMsgRes);
			return executeResponse;
		}
	}

	ExecuteResponse invokeJmsTopicPublisher(ExecuteRequest executeRequestStructure) throws Exception{
		ExecuteResponse executeResponse = new ExecuteResponse();
		
		JMSTopicPublisher topicPub = new JMSTopicPublisher(conn);
		
		if( !((executeRequestStructure.getActivityMetadataRequest()) instanceof PublishMessageRequest)){
			throw new Exception("Invalid request structure ");
		}else{
			PublishMessageRequest pubMsgReq = (PublishMessageRequest)executeRequestStructure.getActivityMetadataRequest();
		
			String topicName =pubMsgReq.getPublishMessageActivityMetadata().getTopicName();
			System.out.println("topicName "+topicName );
			
			String providerClassName = connDTO.getJNDI_FACTORY_INITIAL();
			//TODO
			//Queue queue = JMSUtil.getReferenceToQueue(providerClassName, queueName);
			Topic topic= null;
			//Queue queue = (Queue) sessionMgr.getInitialContext().lookup(sendMsgReq.getSendMessageActivityMetadata().getQueueName());
			PublishMessageResponse pubMessageResponse = topicPub.publishMessages(pubMsgReq, topic);
	
			executeResponse.setActivityName(JMSConstants.ACTIVITY_SEND_MESSAGE);
			executeResponse.setActivityMetadataResponse(pubMessageResponse);
			
		}
		return executeResponse;
	}


}
