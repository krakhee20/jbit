
package org.jitterbit.connector.jms.pojo.publishMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;
import org.jitterbit.connector.jms.pojo.message.MessageList;


/**
 * <p>Java class for publishMessageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="publishMessageRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest">
 *       &lt;sequence>
 *         &lt;element name="publishMessageActivityMetadata" type="{http://www.jitterbit.com/connectors/jms}publishMessageMetadata"/>
 *         &lt;element name="messageList" type="{http://www.jitterbit.com/connectors/jms/message}messageList"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publishMessageRequest", propOrder = {
    "publishMessageActivityMetadata",
    "messageList"
})
public class PublishMessageRequest
    extends ActivityMetadataRequest
{

    @XmlElement(required = true)
    protected PublishMessageMetadata publishMessageActivityMetadata;
    @XmlElement(required = true)
    protected MessageList messageList;

    /**
     * Gets the value of the publishMessageActivityMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link PublishMessageMetadata }
     *     
     */
    public PublishMessageMetadata getPublishMessageActivityMetadata() {
        return publishMessageActivityMetadata;
    }

    /**
     * Sets the value of the publishMessageActivityMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublishMessageMetadata }
     *     
     */
    public void setPublishMessageActivityMetadata(PublishMessageMetadata value) {
        this.publishMessageActivityMetadata = value;
    }

    /**
     * Gets the value of the messageList property.
     * 
     * @return
     *     possible object is
     *     {@link MessageList }
     *     
     */
    public MessageList getMessageList() {
        return messageList;
    }

    /**
     * Sets the value of the messageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageList }
     *     
     */
    public void setMessageList(MessageList value) {
        this.messageList = value;
    }

}
