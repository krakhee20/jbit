package org.jitterbit.connector.jms.sessionmgmt;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.jitterbit.connector.dao.DummyConnectionDTO;

public class QueueConnectionPoolFactory extends BasePooledObjectFactory<Connection>{
	
	private Class<Connection> poolableObj = null;
	Hashtable<String,String> env;
	DummyConnectionDTO connDTO;
	
	protected Class<Connection> getPoolableObject(){
        return poolableObj;
    }
	
    public QueueConnectionPoolFactory(Hashtable<String,String> env, DummyConnectionDTO connDTO){
    	this.env = env;
    	this.connDTO = connDTO;
    }	
     	
	@Override
	public Connection create() throws Exception {
		QueueConnection queueConn=null;
		try {
			Context ctx = new InitialContext(env);
			QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) ctx.lookup(connDTO.getJNDI_JMSJCA_QUEUE_CF());
			queueConn=(QueueConnection) queueConnFactory.createConnection();
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return queueConn;
	}

	@Override
	public PooledObject<Connection> wrap(Connection obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
