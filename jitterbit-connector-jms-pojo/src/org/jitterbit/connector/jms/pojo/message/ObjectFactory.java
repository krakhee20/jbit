
package org.jitterbit.connector.jms.pojo.message;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.jms.pojo.message package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.jms.pojo.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomMessageProperty }
     * 
     */
    public CustomMessageProperty createCustomMessageProperty() {
        return new CustomMessageProperty();
    }

    /**
     * Create an instance of {@link MessageHeaders }
     * 
     */
    public MessageHeaders createMessageHeaders() {
        return new MessageHeaders();
    }

    /**
     * Create an instance of {@link ConnectorMessage }
     * 
     */
    public ConnectorMessage createConnectorMessage() {
        return new ConnectorMessage();
    }

    /**
     * Create an instance of {@link MessageList }
     * 
     */
    public MessageList createMessageList() {
        return new MessageList();
    }

    /**
     * Create an instance of {@link CustomMessagePropertyList }
     * 
     */
    public CustomMessagePropertyList createCustomMessagePropertyList() {
        return new CustomMessagePropertyList();
    }

}
