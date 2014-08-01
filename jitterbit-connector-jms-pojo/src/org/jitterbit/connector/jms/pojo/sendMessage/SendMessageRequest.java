
package org.jitterbit.connector.jms.pojo.sendMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;
import org.jitterbit.connector.jms.pojo.message.MessageList;


/**
 * <p>Java class for sendMessageRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendMessageRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest">
 *       &lt;sequence>
 *         &lt;element name="sendMessageActivityMetadata" type="{http://www.jitterbit.com/connectors/jms}sendMessageMetadata"/>
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
@XmlType(name = "sendMessageRequest", propOrder = {
    "sendMessageActivityMetadata",
    "messageList"
})
public class SendMessageRequest
    extends ActivityMetadataRequest
{

    @XmlElement(required = true)
    protected SendMessageMetadata sendMessageActivityMetadata;
    @XmlElement(required = true)
    protected MessageList messageList;

    /**
     * Gets the value of the sendMessageActivityMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link SendMessageMetadata }
     *     
     */
    public SendMessageMetadata getSendMessageActivityMetadata() {
        return sendMessageActivityMetadata;
    }

    /**
     * Sets the value of the sendMessageActivityMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendMessageMetadata }
     *     
     */
    public void setSendMessageActivityMetadata(SendMessageMetadata value) {
        this.sendMessageActivityMetadata = value;
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
