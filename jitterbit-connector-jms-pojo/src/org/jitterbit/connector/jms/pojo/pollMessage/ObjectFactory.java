
package org.jitterbit.connector.jms.pojo.pollMessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.jms.pojo.pollMessage package. 
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

    private final static QName _PollMessageResponse_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "pollMessageResponse");
    private final static QName _PollMessageRequest_QNAME = new QName("http://www.jitterbit.com/connectors/jms", "pollMessageRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.jms.pojo.pollMessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PollMessageResponse }
     * 
     */
    public PollMessageResponse createPollMessageResponse() {
        return new PollMessageResponse();
    }

    /**
     * Create an instance of {@link PollMessageRequest }
     * 
     */
    public PollMessageRequest createPollMessageRequest() {
        return new PollMessageRequest();
    }

    /**
     * Create an instance of {@link PollMessageActivityMetadata }
     * 
     */
    public PollMessageActivityMetadata createPollMessageActivityMetadata() {
        return new PollMessageActivityMetadata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PollMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "pollMessageResponse")
    public JAXBElement<PollMessageResponse> createPollMessageResponse(PollMessageResponse value) {
        return new JAXBElement<PollMessageResponse>(_PollMessageResponse_QNAME, PollMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PollMessageRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/jms", name = "pollMessageRequest")
    public JAXBElement<PollMessageRequest> createPollMessageRequest(PollMessageRequest value) {
        return new JAXBElement<PollMessageRequest>(_PollMessageRequest_QNAME, PollMessageRequest.class, null, value);
    }

}
