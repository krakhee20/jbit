package org.jitterbit.connector.jms;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.naming.spi.InitialContextFactory;

import org.jitterbit.connector.jms.common.JMSConstants;
import org.jitterbit.connector.jms.pojo.message.CustomMessageProperty;
import org.jitterbit.connector.jms.pojo.message.CustomMessagePropertyList;
import org.jitterbit.connector.jms.pojo.message.MessageHeaders;

public class JMSUtil {
	
	public static Class<?> getProviderClass(String fullPathOfProviderPackage, String providerClassName) throws Exception{
		URLClassLoader urlcl = URLClassLoader.newInstance(new URL[] {
			       new URL("file:////F:/connector/jmsprovider/activemq-all-5.9.1.jar")});
		
		Class<?> clazz = urlcl.loadClass(providerClassName);
		return clazz;		
	}
	
	public static Queue getReferenceToQueue(String providerClassName, String queueName) throws Exception{
		Class<?> providerClass = ClassLoader.getSystemClassLoader().loadClass(providerClassName);
		Class<? extends InitialContextFactory> subClass= providerClass.asSubclass(InitialContextFactory.class);
		//String parameter
		Class[] paramString = new Class[1];	
		paramString[0] = String.class;
		
		Method method =subClass.getDeclaredMethod("createQueue",paramString);
		Queue queue = (Queue) method.invoke(subClass, queueName);
		return queue;
/*		Constructor<? extends InitialContextFactory> ctor= subClass.getConstructor();
		InitialContextFactory object =ctor.newInstance();
*/		
	}
	
	public static void constructMessageHeaders(Message jmsMsg,MessageHeaders msgHeaders,Destination destination) throws JMSException{
		jmsMsg.setJMSCorrelationID(msgHeaders.getJMSCorrelationID());
		jmsMsg.setJMSDeliveryMode(msgHeaders.getJMSDeliveryMode());
		jmsMsg.setJMSExpiration(msgHeaders.getJMSExpiration());
		jmsMsg.setJMSMessageID(msgHeaders.getJMSMessageID());
		jmsMsg.setJMSPriority(msgHeaders.getJMSPriority());
		jmsMsg.setJMSRedelivered(msgHeaders.isJMSRedelivered());
		//currently we are setting the replyTo destination as null
		jmsMsg.setJMSReplyTo(null);
		jmsMsg.setJMSTimestamp(msgHeaders.getJMSTimestamp());
		jmsMsg.setJMSType(msgHeaders.getJMSType());
		jmsMsg.setJMSDestination(destination);
	}
	
	public static void constructMessageProperties(Message jmsMsg,CustomMessagePropertyList customMessagePropertyList) throws JMSException{
        List<CustomMessageProperty> customMessageProperties  =customMessagePropertyList.getCustomMessageProperty();
	
		for(CustomMessageProperty msgProp:customMessageProperties ){
			jmsMsg.setStringProperty(msgProp.getName(), msgProp.getValue());
		}
	}

	public static void constructConnectorMessageHeaders(Message jmsMsg, MessageHeaders msgHeaders) throws JMSException{
		msgHeaders.setJMSCorrelationID(jmsMsg.getJMSCorrelationID());
		msgHeaders.setJMSDeliveryMode(jmsMsg.getJMSDeliveryMode());
		msgHeaders.setJMSDestination(jmsMsg.getJMSDestination().toString());
		msgHeaders.setJMSExpiration(jmsMsg.getJMSExpiration());
		msgHeaders.setJMSMessageID(jmsMsg.getJMSMessageID());
		msgHeaders.setJMSPriority(jmsMsg.getJMSPriority());
		msgHeaders.setJMSRedelivered(jmsMsg.getJMSRedelivered());
		msgHeaders.setJMSReplyTo(jmsMsg.getJMSReplyTo().toString());
		msgHeaders.setJMSTimestamp(jmsMsg.getJMSTimestamp());
		msgHeaders.setJMSType(jmsMsg.getJMSType());
	}

	public static void constructConnectorMessageProperties(Message jmsMsg, CustomMessagePropertyList customMessagePropertyList ) throws JMSException{
        List<CustomMessageProperty> customMessageProperties  =customMessagePropertyList.getCustomMessageProperty();
		int index=0;

		while(index < JMSConstants.ARR_CUSTOM_PROPS.length){
			if(jmsMsg.getStringProperty(JMSConstants.ARR_CUSTOM_PROPS[index]) != null && jmsMsg.getStringProperty(JMSConstants.ARR_CUSTOM_PROPS[index]).isEmpty()){
				CustomMessageProperty customMessageProperty= new CustomMessageProperty(); 
				customMessageProperty.setName(JMSConstants.ARR_CUSTOM_PROPS[index]);
				customMessageProperty.setValue(jmsMsg.getStringProperty(JMSConstants.ARR_CUSTOM_PROPS[index]));
				customMessageProperties.add(customMessageProperty);
				index++;
			}
		}
	}
	
	public static void constructConnectorMessageCustomProperties(Message jmsMsg, CustomMessagePropertyList customMessagePropertyList ) throws JMSException{
        List<CustomMessageProperty> customMessageProperties  =customMessagePropertyList.getCustomMessageProperty();
		Enumeration enumProps = jmsMsg.getPropertyNames();
		while (enumProps.hasMoreElements()) {
			String key =  (String) enumProps.nextElement();
			CustomMessageProperty customMessageProperty= new CustomMessageProperty(); 
			customMessageProperty.setName(key);
			customMessageProperty.setValue(jmsMsg.getStringProperty(key));
			customMessageProperties.add(customMessageProperty);
		    }
	}
	
}
