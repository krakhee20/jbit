/**
 * 
 */
package org.jitterbit.connector.jms.sessionmgmt;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import javax.jms.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author acer
 *
 */
public class ConnectionPool extends GenericObjectPool<Connection> {

	public ConnectionPool(PooledObjectFactory<Connection> factory) {
		super(factory);
		
	}
	
	

}
