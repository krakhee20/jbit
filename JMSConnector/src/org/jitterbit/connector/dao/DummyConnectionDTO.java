package org.jitterbit.connector.dao;

public class DummyConnectionDTO {
	public String JNDI_PROVIDER_URL="tcp://localhost:61616";
	public String JNDI_FACTORY_INITIAL="org.apache.activemq.jndi.ActiveMQInitialContextFactory";
	public String JNDI_SECURITY_PRINCIPAL="admin";
	public String JNDI_SECURITY_CREDENTIALS="admin";
	public String JNDI_JMSJCA_UNIFIED_CF="JMSJCA.UnifiedCF";
	public String JNDI_JMSJCA_TOPIC_CF="TopicConnectionFactory";
	public String JNDI_JMSJCA_QUEUE_CF="QueueConnectionFactory";
	
	public boolean isTransacted = false;
	public String acknowledgementMode;
	public boolean isTransacted() {
		return isTransacted;
	}
	public void setTransacted(boolean isTransacted) {
		this.isTransacted = isTransacted;
	}
	public String getAcknowledgementMode() {
		return acknowledgementMode;
	}
	public void setAcknowledgementMode(String acknowledgementMode) {
		this.acknowledgementMode = acknowledgementMode;
	}
	public String getJNDI_PROVIDER_URL() {
		return JNDI_PROVIDER_URL;
	}
	public void setJNDI_PROVIDER_URL(String jNDI_PROVIDER_URL) {
		JNDI_PROVIDER_URL = jNDI_PROVIDER_URL;
	}
	public String getJNDI_FACTORY_INITIAL() {
		return JNDI_FACTORY_INITIAL;
	}
	public void setJNDI_FACTORY_INITIAL(String jNDI_FACTORY_INITIAL) {
		JNDI_FACTORY_INITIAL = jNDI_FACTORY_INITIAL;
	}
	public String getJNDI_SECURITY_PRINCIPAL() {
		return JNDI_SECURITY_PRINCIPAL;
	}
	public void setJNDI_SECURITY_PRINCIPAL(String jNDI_SECURITY_PRINCIPAL) {
		JNDI_SECURITY_PRINCIPAL = jNDI_SECURITY_PRINCIPAL;
	}
	public String getJNDI_SECURITY_CREDENTIALS() {
		return JNDI_SECURITY_CREDENTIALS;
	}
	public void setJNDI_SECURITY_CREDENTIALS(String jNDI_SECURITY_CREDENTIALS) {
		JNDI_SECURITY_CREDENTIALS = jNDI_SECURITY_CREDENTIALS;
	}
	public String getJNDI_JMSJCA_UNIFIED_CF() {
		return JNDI_JMSJCA_UNIFIED_CF;
	}
	public void setJNDI_JMSJCA_UNIFIED_CF(String jNDI_JMSJCA_UNIFIED_CF) {
		JNDI_JMSJCA_UNIFIED_CF = jNDI_JMSJCA_UNIFIED_CF;
	}
	public String getJNDI_JMSJCA_TOPIC_CF() {
		return JNDI_JMSJCA_TOPIC_CF;
	}
	public void setJNDI_JMSJCA_TOPIC_CF(String jNDI_JMSJCA_TOPIC_CF) {
		JNDI_JMSJCA_TOPIC_CF = jNDI_JMSJCA_TOPIC_CF;
	}
	public String getJNDI_JMSJCA_QUEUE_CF() {
		return JNDI_JMSJCA_QUEUE_CF;
	}
	public void setJNDI_JMSJCA_QUEUE_CF(String jNDI_JMSJCA_QUEUE_CF) {
		JNDI_JMSJCA_QUEUE_CF = jNDI_JMSJCA_QUEUE_CF;
	}
	
}
