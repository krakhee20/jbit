
package org.jitterbit.connector.jms.pojo.subscribeMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;


/**
 * <p>Java class for subscribeMessageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscribeMessageRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest">
 *       &lt;sequence>
 *         &lt;element name="subscribeMessageActivityMetadata" type="{http://www.jitterbit.com/connectors/jms}subscribeMessageActivityMetadata"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscribeMessageRequest", propOrder = {
    "subscribeMessageActivityMetadata"
})
public class SubscribeMessageRequest
    extends ActivityMetadataRequest
{

    @XmlElement(required = true)
    protected SubscribeMessageActivityMetadata subscribeMessageActivityMetadata;

    /**
     * Gets the value of the subscribeMessageActivityMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link SubscribeMessageActivityMetadata }
     *     
     */
    public SubscribeMessageActivityMetadata getSubscribeMessageActivityMetadata() {
        return subscribeMessageActivityMetadata;
    }

    /**
     * Sets the value of the subscribeMessageActivityMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscribeMessageActivityMetadata }
     *     
     */
    public void setSubscribeMessageActivityMetadata(SubscribeMessageActivityMetadata value) {
        this.subscribeMessageActivityMetadata = value;
    }

}
