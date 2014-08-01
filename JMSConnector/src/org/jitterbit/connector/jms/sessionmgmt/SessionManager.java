/**
 * 
 */
package org.jitterbit.connector.jms.sessionmgmt;

import java.util.Hashtable;

import javax.jms.Connection;
/**
 * @author acer
 *
 */
public interface SessionManager {

	Connection createConnection(Hashtable<String,String> connectionProperties) throws Exception;
	
	SessionResponse addConnectionToPool(Connection connection);
	
	boolean removeConnectionFromPool(String sessionKey);

	Connection getConnectionFromPool(String sessionKey);
	
	boolean removeAllConnections();
}
