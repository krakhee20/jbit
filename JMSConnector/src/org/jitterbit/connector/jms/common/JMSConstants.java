package org.jitterbit.connector.jms.common;

public class JMSConstants {
	
	public static String PROP_GROUP_CONNECTION = "Connection Properties";
	public static String APPLICATION_DOMAIN = "General";
	
	//message related
	public static String MESSAGE_TYPE_TEXT="TEXT";
	public static String MESSAGE_TYPE_BYTE="BYTE";
	public static String END_OF_MESSAGE="End Of Message";
	
	//activity list
	public static int NUMBER_OF_ACTIVITIES = 6;
	public static String ACTIVITY_SEND_MESSAGE = "Send Message";
	public static String ACTIVITY_RECEIVE_MESSAGE = "Receive Message";
	public static String ACTIVITY_POLL_MESSAGE = "Poll Message";
	public static String ACTIVITY_LISTEN_MESSAGE = "Listen Message";
	public static String ACTIVITY_PUBLISH_MESSAGE = "Publish Message";
	public static String ACTIVITY_SUBSCRIBE_MESSAGE = "Subscribe Message";
	public static String ACTIVITY_QUEUE_BROWSER = "Queue Browser";
	
	public static String ACTIVITY_NAMES_ARR [] ={ACTIVITY_SEND_MESSAGE, ACTIVITY_RECEIVE_MESSAGE, ACTIVITY_POLL_MESSAGE,
		ACTIVITY_PUBLISH_MESSAGE, ACTIVITY_SUBSCRIBE_MESSAGE, ACTIVITY_QUEUE_BROWSER}; 
	
	public static String DEDICATED_API_CALL ="Dedicated API Call";
	
	public static String JNDI_PROVIDER_URL="java.naming.provider.url";
	public static String JNDI_FACTORY_INITIAL="java.naming.factory.initial";
	public static String JNDI_SECURITY_PRINCIPAL="java.naming.security.principal";
	public static String JNDI_SECURITY_CREDENTIALS="java.naming.security.credentials";
	public static String JNDI_JMSJCA_UNIFIED_CF="JMSJCA.UnifiedCF";
	public static String JNDI_JMSJCA_TOPIC_CF="JMSJCA.TopicCF";
	public static String JNDI_JMSJCA_QUEUE_CF="JMSJCA.QueueCF";
	

	public static String ARR_CUSTOM_PROPS[] = {"JMSXUserID","JMSXAppID","JMSXProducerTIXID","JMSXConsumerTXID","JMSXRcvTimestamp","JMSXDeliveryCount",
			"JMSXGroupID","JMSXGroupSeq"}; 
	
}
