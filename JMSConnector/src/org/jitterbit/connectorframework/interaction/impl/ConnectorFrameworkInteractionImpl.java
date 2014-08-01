/**
 * 
 */
package org.jitterbit.connectorframework.interaction.impl;

import java.util.List;

import org.jitterbit.connector.framework.pojo.execute.ExecuteRequest;
import org.jitterbit.connector.framework.pojo.execute.ExecuteResponse;
import org.jitterbit.connector.framework.pojo.metadata.ActivityListRequest;
import org.jitterbit.connector.framework.pojo.metadata.ActivityListResponse;
import org.jitterbit.connector.framework.pojo.metadata.ActivityListResponse.Activity;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadata;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataResponse;
import org.jitterbit.connector.framework.pojo.metadata.ApplicationDomain;
import org.jitterbit.connector.framework.pojo.metadata.ApplicationDomainsResponse;
import org.jitterbit.connector.framework.pojo.sessionmanagement.ConnectorProperties;
import org.jitterbit.connector.framework.pojo.sessionmanagement.ConnectorProperty;
import org.jitterbit.connector.framework.pojo.sessionmanagement.ConnectorPropertyGroup;
import org.jitterbit.connector.framework.pojo.sessionmanagement.ConnectorPropertyGroups;
import org.jitterbit.connector.framework.pojo.sessionmanagement.PoolSize;
import org.jitterbit.connector.framework.pojo.sessionmanagement.PoolSizeResponse;
import org.jitterbit.connector.jms.JMSConnector;
import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageRequest;
import org.jitterbit.connector.jms.pojo.receiveMessage.ReceiveMessageResponse;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageMetadata;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageRequest;
import org.jitterbit.connector.jms.pojo.sendMessage.SendMessageResponse;
import org.jitterbit.connector.jms.pojo.sessionmanagement.JmsConnectorProperty;
import org.jitterbit.connectorframework.interaction.ConnectorFrameworkInteraction;

/**
 * @author Rakhee
 *
 */
public class ConnectorFrameworkInteractionImpl implements
		ConnectorFrameworkInteraction {
	JMSConnector jmsConn;
	ConnectorFrameworkInteractionImpl(){
		jmsConn = new JMSConnector();
	}
	/* (non-Javadoc)
	 * @see org.jitterbit.connectorframework.interaction.ConnectorFrameworkInteraction#getApplicationDomains(org.jitterbit.connector.framework.pojo.metadata.ApplicationDomainsRequest)
	 */
	@Override
	public ApplicationDomainsResponse getApplicationDomains() {
		ApplicationDomainsResponse appDomainsResponse =new ApplicationDomainsResponse();
		ApplicationDomain appDomain = new ApplicationDomain();
		appDomain.setName(JMSConstants.APPLICATION_DOMAIN);
		appDomain.setChildDomainsPresent(false);
		appDomainsResponse.getApplicationDomain().add(appDomain );
		return appDomainsResponse;
	}

	/* (non-Javadoc)
	 * @see org.jitterbit.connectorframework.interaction.ConnectorFrameworkInteraction#getActivityList(org.jitterbit.connector.framework.pojo.metadata.ActivityListRequest)
	 */
	@Override
	public ActivityListResponse getActivityList(
			ActivityListRequest activityListRequest) {
		ActivityListResponse activityListResponse = new ActivityListResponse();
		
		List<Activity> activityList = activityListResponse.getActivity();

		int index=0;
		while(index < JMSConstants.ACTIVITY_NAMES_ARR.length){
			Activity activity = new Activity();
			activity.setActivityName(JMSConstants.ACTIVITY_NAMES_ARR[index]);
			activity.setApplicationDomain(JMSConstants.APPLICATION_DOMAIN);
			activity.setActivityType(JMSConstants.DEDICATED_API_CALL);
			activityList.add(activity);
			index++;
		}
		
		return activityListResponse;
	}
	

	@Override
	public PoolSizeResponse setPoolSize(PoolSize poolSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityMetadataRequest getActivityMetadataRequestStructure(
			ActivityMetadata activityMetadata) {

		String activityName = activityMetadata.getActivityName();
		if(activityName.equals(JMSConstants.ACTIVITY_SEND_MESSAGE)){
			SendMessageMetadata sendMsgMetadata = new SendMessageMetadata();
			SendMessageRequest sendMsgReq = new SendMessageRequest();
			sendMsgReq.setSendMessageActivityMetadata(sendMsgMetadata);
			return sendMsgReq;
		}else if(activityName.equals(JMSConstants.ACTIVITY_RECEIVE_MESSAGE)){
			return new ReceiveMessageRequest();
		}

		return null;
	}

	@Override
	public ActivityMetadataResponse getActivityMetadataResponseStructure(
			ActivityMetadata activityMetadata) {
		String activityName = activityMetadata.getActivityName();
		if(activityName.equals(JMSConstants.ACTIVITY_SEND_MESSAGE)){
			return new SendMessageResponse();
		}else if(activityName.equals(JMSConstants.ACTIVITY_RECEIVE_MESSAGE)){
			return new ReceiveMessageResponse();
		}

		return null;
	}

	@Override
	public ExecuteResponse execute(ExecuteRequest executeRequestStructure) {
		return jmsConn.execute(executeRequestStructure);
	}

	@Override
	public boolean createConnection() {
		return jmsConn.createConnection();
	}
/*	@Override
	public ConnectorPropertyGroups getConnectorPropertyGroups() {
		ConnectorPropertyGroups connectorPropertyGroups = new ConnectorPropertyGroups ();
		List<ConnectorPropertyGroup> connectorPropertyGroupList = connectorPropertyGroups.getConnectorPropertyGroup();
		ConnectorPropertyGroup connectorPropertyGroup = new ConnectorPropertyGroup();
		connectorPropertyGroup.setConnectorPropertyGroupName(JMSConstants.PROP_GROUP_CONNECTION);
		
		ConnectorProperties connectorProperties = new ConnectorProperties();
		List<ConnectorProperty> connectorPropertyList = connectorProperties.getConnectorProperty();

		JmsConnectorProperty jmsConnectorProperty= new JmsConnectorProperty();
		jmsConnectorProperty.setName(JMSConstants.JNDI_FACTORY_INITIAL);
		
		connectorPropertyGroup.setConnectorProperties(connectorProperties );
		connectorPropertyGroupList.add(connectorPropertyGroup);
		
		
		return null;
	}
*/}


