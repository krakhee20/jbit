
package org.jitterbit.connector.framework.pojo.execute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for asynchronousRequestStructure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="asynchronousRequestStructure">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectors/sugarcrm/schema}executeRequest">
 *       &lt;sequence>
 *         &lt;element name="CallBackHandlerString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "asynchronousRequestStructure", propOrder = {
    "callBackHandlerString"
})
public class AsynchronousRequestStructure
    extends ExecuteRequest
{

    @XmlElement(name = "CallBackHandlerString", required = true)
    protected String callBackHandlerString;

    /**
     * Gets the value of the callBackHandlerString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallBackHandlerString() {
        return callBackHandlerString;
    }

    /**
     * Sets the value of the callBackHandlerString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallBackHandlerString(String value) {
        this.callBackHandlerString = value;
    }

}
