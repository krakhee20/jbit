
package org.jitterbit.connector.jms.pojo.queueBrowser;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.jms.pojo.queueBrowser package. 
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

    private final static QName _QueueBrowserResponse_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "queueBrowserResponse");
    private final static QName _QueueBrowserRequest_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "queueBrowserRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.jms.pojo.queueBrowser
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueueBrowserResponse }
     * 
     */
    public QueueBrowserResponse createQueueBrowserResponse() {
        return new QueueBrowserResponse();
    }

    /**
     * Create an instance of {@link QueueBrowserRequest }
     * 
     */
    public QueueBrowserRequest createQueueBrowserRequest() {
        return new QueueBrowserRequest();
    }

    /**
     * Create an instance of {@link QueueBrowserActivityMetadata }
     * 
     */
    public QueueBrowserActivityMetadata createQueueBrowserActivityMetadata() {
        return new QueueBrowserActivityMetadata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueueBrowserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "queueBrowserResponse")
    public JAXBElement<QueueBrowserResponse> createQueueBrowserResponse(QueueBrowserResponse value) {
        return new JAXBElement<QueueBrowserResponse>(_QueueBrowserResponse_QNAME, QueueBrowserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueueBrowserRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "queueBrowserRequest")
    public JAXBElement<QueueBrowserRequest> createQueueBrowserRequest(QueueBrowserRequest value) {
        return new JAXBElement<QueueBrowserRequest>(_QueueBrowserRequest_QNAME, QueueBrowserRequest.class, null, value);
    }

}
