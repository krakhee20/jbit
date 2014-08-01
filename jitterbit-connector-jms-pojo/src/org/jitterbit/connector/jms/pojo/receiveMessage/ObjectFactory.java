
package org.jitterbit.connector.jms.pojo.receiveMessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.jms.pojo.receiveMessage package. 
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

    private final static QName _ReceiveMessageResponse_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "receiveMessageResponse");
    private final static QName _ReceiveMessageRequest_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "receiveMessageRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.jms.pojo.receiveMessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceiveMessageResponse }
     * 
     */
    public ReceiveMessageResponse createReceiveMessageResponse() {
        return new ReceiveMessageResponse();
    }

    /**
     * Create an instance of {@link ReceiveMessageRequest }
     * 
     */
    public ReceiveMessageRequest createReceiveMessageRequest() {
        return new ReceiveMessageRequest();
    }

    /**
     * Create an instance of {@link ReceiveMessageActivityMetadata }
     * 
     */
    public ReceiveMessageActivityMetadata createReceiveMessageActivityMetadata() {
        return new ReceiveMessageActivityMetadata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "receiveMessageResponse")
    public JAXBElement<ReceiveMessageResponse> createReceiveMessageResponse(ReceiveMessageResponse value) {
        return new JAXBElement<ReceiveMessageResponse>(_ReceiveMessageResponse_QNAME, ReceiveMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "receiveMessageRequest")
    public JAXBElement<ReceiveMessageRequest> createReceiveMessageRequest(ReceiveMessageRequest value) {
        return new JAXBElement<ReceiveMessageRequest>(_ReceiveMessageRequest_QNAME, ReceiveMessageRequest.class, null, value);
    }

}
