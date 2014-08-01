
package org.jitterbit.connector.jms.pojo.pollMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;


/**
 * <p>Java class for pollMessageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pollMessageRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest">
 *       &lt;sequence>
 *         &lt;element name="pollMessageActivityMetadata" type="{http://www.jitterbit.com/connectors/jms}pollMessageActivityMetadata"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pollMessageRequest", propOrder = {
    "pollMessageActivityMetadata"
})
public class PollMessageRequest
    extends ActivityMetadataRequest
{

    @XmlElement(required = true)
    protected PollMessageActivityMetadata pollMessageActivityMetadata;

    /**
     * Gets the value of the pollMessageActivityMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link PollMessageActivityMetadata }
     *     
     */
    public PollMessageActivityMetadata getPollMessageActivityMetadata() {
        return pollMessageActivityMetadata;
    }

    /**
     * Sets the value of the pollMessageActivityMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link PollMessageActivityMetadata }
     *     
     */
    public void setPollMessageActivityMetadata(PollMessageActivityMetadata value) {
        this.pollMessageActivityMetadata = value;
    }

}
