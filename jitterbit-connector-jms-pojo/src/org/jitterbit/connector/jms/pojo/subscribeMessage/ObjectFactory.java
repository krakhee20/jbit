
package org.jitterbit.connector.jms.pojo.subscribeMessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.jms.pojo.subscribeMessage package. 
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

    private final static QName _SubscribeMessageRequest_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "subscribeMessageRequest");
    private final static QName _SubscribeMessageResponse_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "subscribeMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.jms.pojo.subscribeMessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubscribeMessageRequest }
     * 
     */
    public SubscribeMessageRequest createSubscribeMessageRequest() {
        return new SubscribeMessageRequest();
    }

    /**
     * Create an instance of {@link SubscribeMessageResponse }
     * 
     */
    public SubscribeMessageResponse createSubscribeMessageResponse() {
        return new SubscribeMessageResponse();
    }

    /**
     * Create an instance of {@link SubscribeMessageActivityMetadata }
     * 
     */
    public SubscribeMessageActivityMetadata createSubscribeMessageActivityMetadata() {
        return new SubscribeMessageActivityMetadata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "subscribeMessageRequest")
    public JAXBElement<SubscribeMessageRequest> createSubscribeMessageRequest(SubscribeMessageRequest value) {
        return new JAXBElement<SubscribeMessageRequest>(_SubscribeMessageRequest_QNAME, SubscribeMessageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscribeMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "subscribeMessageResponse")
    public JAXBElement<SubscribeMessageResponse> createSubscribeMessageResponse(SubscribeMessageResponse value) {
        return new JAXBElement<SubscribeMessageResponse>(_SubscribeMessageResponse_QNAME, SubscribeMessageResponse.class, null, value);
    }

}
