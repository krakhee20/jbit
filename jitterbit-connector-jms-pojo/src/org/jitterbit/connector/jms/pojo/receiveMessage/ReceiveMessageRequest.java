
package org.jitterbit.connector.jms.pojo.receiveMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;


/**
 * <p>Java class for receiveMessageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="receiveMessageRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest">
 *       &lt;sequence>
 *         &lt;element name="receiveMessageActivityMetadata" type="{http://www.jitterbit.com/connectors/jms}receiveMessageActivityMetadata"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receiveMessageRequest", propOrder = {
    "receiveMessageActivityMetadata"
})
public class ReceiveMessageRequest
    extends ActivityMetadataRequest
{

    @XmlElement(required = true)
    protected ReceiveMessageActivityMetadata receiveMessageActivityMetadata;

    /**
     * Gets the value of the receiveMessageActivityMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link ReceiveMessageActivityMetadata }
     *     
     */
    public ReceiveMessageActivityMetadata getReceiveMessageActivityMetadata() {
        return receiveMessageActivityMetadata;
    }

    /**
     * Sets the value of the receiveMessageActivityMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceiveMessageActivityMetadata }
     *     
     */
    public void setReceiveMessageActivityMetadata(ReceiveMessageActivityMetadata value) {
        this.receiveMessageActivityMetadata = value;
    }

}
