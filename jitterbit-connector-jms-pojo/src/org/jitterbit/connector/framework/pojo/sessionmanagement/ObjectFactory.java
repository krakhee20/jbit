
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.framework.pojo.sessionmanagement package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SessionKey_QNAME = new QName("http://www.jitterbit.com/connectorframework/sessionmgmt", "sessionKey");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.framework.pojo.sessionmanagement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SessionResponse }
     * 
     */
    public SessionResponse createSessionResponse() {
        return new SessionResponse();
    }

    /**
     * Create an instance of {@link PoolSize }
     * 
     */
    public PoolSize createPoolSize() {
        return new PoolSize();
    }

    /**
     * Create an instance of {@link PoolSizeResponse }
     * 
     */
    public PoolSizeResponse createPoolSizeResponse() {
        return new PoolSizeResponse();
    }

    /**
     * Create an instance of {@link ConnectorProperty }
     * 
     */
    public ConnectorProperty createConnectorProperty() {
        return new ConnectorProperty();
    }

    /**
     * Create an instance of {@link ConnectorPropertyGroups }
     * 
     */
    public ConnectorPropertyGroups createConnectorPropertyGroups() {
        return new ConnectorPropertyGroups();
    }

    /**
     * Create an instance of {@link ConnectorProperties }
     * 
     */
    public ConnectorProperties createConnectorProperties() {
        return new ConnectorProperties();
    }

    /**
     * Create an instance of {@link ConnectorPropertyGroup }
     * 
     */
    public ConnectorPropertyGroup createConnectorPropertyGroup() {
        return new ConnectorPropertyGroup();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectorframework/sessionmgmt", name = "sessionKey")
    public JAXBElement<String> createSessionKey(String value) {
        return new JAXBElement<String>(_SessionKey_QNAME, String.class, null, value);
    }

}
