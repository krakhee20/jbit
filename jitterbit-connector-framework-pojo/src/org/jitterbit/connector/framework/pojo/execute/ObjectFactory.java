
package org.jitterbit.connector.framework.pojo.execute;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.jitterbit.connector.framework.pojo.execute package. 
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

    private final static QName _ExecuteAsyncRequest_QNAME = new QName("http://www.jitterbit.com/connectors/sugarcrm/schema", "executeAsyncRequest");
    private final static QName _ExecuteResponse_QNAME = new QName("http://www.jitterbit.com/connectors/sugarcrm/schema", "executeResponse");
    private final static QName _ExecuteRequest_QNAME = new QName("http://www.jitterbit.com/connectors/sugarcrm/schema", "executeRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.jitterbit.connector.framework.pojo.execute
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AsynchronousRequestStructure }
     * 
     */
    public AsynchronousRequestStructure createAsynchronousRequestStructure() {
        return new AsynchronousRequestStructure();
    }

    /**
     * Create an instance of {@link ExecuteResponse }
     * 
     */
    public ExecuteResponse createExecuteResponse() {
        return new ExecuteResponse();
    }

    /**
     * Create an instance of {@link ExecuteRequest }
     * 
     */
    public ExecuteRequest createExecuteRequest() {
        return new ExecuteRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AsynchronousRequestStructure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/sugarcrm/schema", name = "executeAsyncRequest")
    public JAXBElement<AsynchronousRequestStructure> createExecuteAsyncRequest(AsynchronousRequestStructure value) {
        return new JAXBElement<AsynchronousRequestStructure>(_ExecuteAsyncRequest_QNAME, AsynchronousRequestStructure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/sugarcrm/schema", name = "executeResponse")
    public JAXBElement<ExecuteResponse> createExecuteResponse(ExecuteResponse value) {
        return new JAXBElement<ExecuteResponse>(_ExecuteResponse_QNAME, ExecuteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jitterbit.com/connectors/sugarcrm/schema", name = "executeRequest")
    public JAXBElement<ExecuteRequest> createExecuteRequest(ExecuteRequest value) {
        return new JAXBElement<ExecuteRequest>(_ExecuteRequest_QNAME, ExecuteRequest.class, null, value);
    }

}
