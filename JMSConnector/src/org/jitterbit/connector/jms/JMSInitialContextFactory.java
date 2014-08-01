package org.jitterbit.connector.jms;

import javax.jms.Queue;
import javax.naming.spi.InitialContextFactory;

public interface JMSInitialContextFactory extends InitialContextFactory{
	
	Queue createQueue(String queueName);

}
