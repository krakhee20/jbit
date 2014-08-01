
package org.jitterbit.connector.jms.pojo.queueBrowser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;


/**
 * <p>Java class for queueBrowserRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queueBrowserRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest">
 *       &lt;sequence>
 *         &lt;element name="queueBrowserActivityMetadata" type="{http://www.jitterbit.com/connectors/jms}queueBrowserActivityMetadata"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queueBrowserRequest", propOrder = {
    "queueBrowserActivityMetadata"
})
public class QueueBrowserRequest
    extends ActivityMetadataRequest
{

    @XmlElement(required = true)
    protected QueueBrowserActivityMetadata queueBrowserActivityMetadata;

    /**
     * Gets the value of the queueBrowserActivityMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link QueueBrowserActivityMetadata }
     *     
     */
    public QueueBrowserActivityMetadata getQueueBrowserActivityMetadata() {
        return queueBrowserActivityMetadata;
    }

    /**
     * Sets the value of the queueBrowserActivityMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueBrowserActivityMetadata }
     *     
     */
    public void setQueueBrowserActivityMetadata(QueueBrowserActivityMetadata value) {
        this.queueBrowserActivityMetadata = value;
    }

}
