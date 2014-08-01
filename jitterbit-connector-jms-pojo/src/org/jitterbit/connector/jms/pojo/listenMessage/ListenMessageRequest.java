
package org.jitterbit.connector.jms.pojo.listenMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;


/**
 * <p>Java class for listenMessageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listenMessageRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest">
 *       &lt;sequence>
 *         &lt;element name="listenMessageActivityMetadata" type="{http://www.jitterbit.com/connectors/jms}listenMessageActivityMetadata"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listenMessageRequest", propOrder = {
    "listenMessageActivityMetadata"
})
public class ListenMessageRequest
    extends ActivityMetadataRequest
{

    @XmlElement(required = true)
    protected ListenMessageActivityMetadata listenMessageActivityMetadata;

    /**
     * Gets the value of the listenMessageActivityMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link ListenMessageActivityMetadata }
     *     
     */
    public ListenMessageActivityMetadata getListenMessageActivityMetadata() {
        return listenMessageActivityMetadata;
    }

    /**
     * Sets the value of the listenMessageActivityMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListenMessageActivityMetadata }
     *     
     */
    public void setListenMessageActivityMetadata(ListenMessageActivityMetadata value) {
        this.listenMessageActivityMetadata = value;
    }

}
