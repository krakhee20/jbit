/**
 * 
 */
package org.jitterbit.connector.jms.sessionmgmt;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;

import org.apache.commons.pool2.ObjectPool;
import org.jitterbit.connector.dao.DummyConnectionDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author acer
 *
 */
public class SessionManagerImpl implements SessionManager {
	DummyConnectionDTO connDTO;
	QueueConnection queueConn;
	TopicConnection topicConn;
	QueueSession queueSession;
	TopicSession topicSession;
	Context jndiContext;
	Connection connection;
	
	public SessionManagerImpl(DummyConnectionDTO connDTO){
		this.connDTO = connDTO;
	}


	/* (non-Javadoc)
	 * @see org.jitterbit.connector.jms.sessionmgmt.SessionManager#createConnection(java.util.HashMap)
	 */
	@Override
	public Connection createConnection(Hashtable env) throws Exception {
		ConnectionFactory connFactory = (ConnectionFactory) getInitialContext().lookup("ConnectionFactory");
		connection= connFactory.createConnection();
		
		return connection;
	}
	
	public Session createSession(Connection conn){
		Session session=null;
		try {
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
		
	}

	public QueueConnection createQueueConnection(Hashtable<String,String> env) throws Exception{
		//QueueConnection queueConn=null;
		
		QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) getInitialContext().lookup(connDTO.getJNDI_JMSJCA_QUEUE_CF());
		queueConn=(QueueConnection) queueConnFactory.createConnection();
		return queueConn;
	}

	public QueueSession createQueueSession(QueueConnection queueConn){
		//QueueSession queueSession =null;
		try {
			queueConn.createQueueSession(connDTO.isTransacted, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return queueSession;
	}

	public TopicConnection createTopicConnection(Hashtable<String,String> env) throws Exception{
		//TopicConnection topicConn=null;
		TopicConnectionFactory topicConnFactory = (TopicConnectionFactory) getInitialContext().lookup(connDTO.getJNDI_JMSJCA_TOPIC_CF());
		topicConn=(TopicConnection) topicConnFactory.createConnection();
		return topicConn;
	}
	
	public TopicSession createTopicSession(TopicConnection topicConn) throws JMSException{
		//TopicSession topicSession =null;
		topicConn.createTopicSession(connDTO.isTransacted, Session.AUTO_ACKNOWLEDGE);
		
		return topicSession;
	}

	/* (non-Javadoc)
	 * @see org.jitterbit.connector.jms.sessionmgmt.SessionManager#addConnectionToPool(javax.jms.Connection)
	 */
	@Override
	public SessionResponse addConnectionToPool(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jitterbit.connector.jms.sessionmgmt.SessionManager#removeConnectionFromPool(java.lang.String)
	 */
	@Override
	public boolean removeConnectionFromPool(String sessionKey) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.jitterbit.connector.jms.sessionmgmt.SessionManager#getConnectionFromPool(java.lang.String)
	 */
	@Override
	public Connection getConnectionFromPool(String sessionKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jitterbit.connector.jms.sessionmgmt.SessionManager#removeAllConnections()
	 */
	@Override
	public boolean removeAllConnections() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setInitialContext(Hashtable<String,String> env) throws Exception{
		if(jndiContext == null)
			jndiContext = new InitialContext(env);
	}
	public Context getInitialContext() throws Exception{
		return jndiContext ;
		
	}

	public void closeConnection(Connection connection) throws Exception{
		if(connection != null)
			connection.close();
	}
}
