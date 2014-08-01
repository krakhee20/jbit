
package org.jitterbit.connector.jms.pojo.publishMessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.jms.pojo.publishMessage package. 
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

    private final static QName _PublishMessageResponse_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "publishMessageResponse");
    private final static QName _PublishMessageRequest_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "publishMessageRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.jms.pojo.publishMessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PublishMessageResponse }
     * 
     */
    public PublishMessageResponse createPublishMessageResponse() {
        return new PublishMessageResponse();
    }

    /**
     * Create an instance of {@link PublishMessageRequest }
     * 
     */
    public PublishMessageRequest createPublishMessageRequest() {
        return new PublishMessageRequest();
    }

    /**
     * Create an instance of {@link PublishMessageMetadata }
     * 
     */
    public PublishMessageMetadata createPublishMessageMetadata() {
        return new PublishMessageMetadata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "publishMessageResponse")
    public JAXBElement<PublishMessageResponse> createPublishMessageResponse(PublishMessageResponse value) {
        return new JAXBElement<PublishMessageResponse>(_PublishMessageResponse_QNAME, PublishMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublishMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "publishMessageRequest")
    public JAXBElement<PublishMessageRequest> createPublishMessageRequest(PublishMessageRequest value) {
        return new JAXBElement<PublishMessageRequest>(_PublishMessageRequest_QNAME, PublishMessageRequest.class, null, value);
    }

}
