/**
 * 
 */
package org.jitterbit.connectorframework.interaction;

import org.jitterbit.connector.framework.pojo.execute.ExecuteRequest;
import org.jitterbit.connector.framework.pojo.execute.ExecuteResponse;
import org.jitterbit.connector.framework.pojo.metadata.ActivityListRequest;
import org.jitterbit.connector.framework.pojo.metadata.ActivityListResponse;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadata;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataResponse;
import org.jitterbit.connector.framework.pojo.metadata.ApplicationDomainsResponse;
import org.jitterbit.connector.framework.pojo.sessionmanagement.PoolSize;
import org.jitterbit.connector.framework.pojo.sessionmanagement.PoolSizeResponse;

/**
 * @author Rakhee
 *
 */
public interface ConnectorFrameworkInteraction {
	
	boolean createConnection();

	ApplicationDomainsResponse getApplicationDomains();
	
	ActivityListResponse getActivityList(ActivityListRequest activityListRequest);
	
	ActivityMetadataRequest getActivityMetadataRequestStructure(ActivityMetadata activityMetadata);
	
	ActivityMetadataResponse getActivityMetadataResponseStructure(ActivityMetadata activityMetadata);
	
	PoolSizeResponse setPoolSize(PoolSize poolSize);
	
	ExecuteResponse execute(ExecuteRequest executeRequestStructure);
	
	
}
