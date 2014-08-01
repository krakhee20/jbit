
package org.jitterbit.connector.jms.pojo.listenMessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.jms.pojo.listenMessage package. 
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

    private final static QName _ListenMessageRequest_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "listenMessageRequest");
    private final static QName _ListenMessageResponse_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "listenMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.jms.pojo.listenMessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListenMessageRequest }
     * 
     */
    public ListenMessageRequest createListenMessageRequest() {
        return new ListenMessageRequest();
    }

    /**
     * Create an instance of {@link ListenMessageResponse }
     * 
     */
    public ListenMessageResponse createListenMessageResponse() {
        return new ListenMessageResponse();
    }

    /**
     * Create an instance of {@link ListenMessageActivityMetadata }
     * 
     */
    public ListenMessageActivityMetadata createListenMessageActivityMetadata() {
        return new ListenMessageActivityMetadata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListenMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "listenMessageRequest")
    public JAXBElement<ListenMessageRequest> createListenMessageRequest(ListenMessageRequest value) {
        return new JAXBElement<ListenMessageRequest>(_ListenMessageRequest_QNAME, ListenMessageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListenMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "listenMessageResponse")
    public JAXBElement<ListenMessageResponse> createListenMessageResponse(ListenMessageResponse value) {
        return new JAXBElement<ListenMessageResponse>(_ListenMessageResponse_QNAME, ListenMessageResponse.class, null, value);
    }

}
