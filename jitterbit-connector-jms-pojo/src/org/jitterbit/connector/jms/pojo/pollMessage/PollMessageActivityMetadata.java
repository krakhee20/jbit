
package org.jitterbit.connector.jms.pojo.pollMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pollMessageActivityMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pollMessageActivityMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="queueName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageSelector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pollingInterval" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="acknowledgeMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pollMessageActivityMetadata", propOrder = {
    "queueName",
    "messageType",
    "messageSelector",
    "pollingInterval",
    "acknowledgeMode"
})
public class PollMessageActivityMetadata {

    @XmlElement(required = true)
    protected String queueName;
    @XmlElement(required = true)
    protected String messageType;
    @XmlElement(required = true)
    protected String messageSelector;
    protected long pollingInterval;
    protected int acknowledgeMode;

    /**
     * Gets the value of the queueName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * Sets the value of the queueName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueueName(String value) {
        this.queueName = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the messageSelector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageSelector() {
        return messageSelector;
    }

    /**
     * Sets the value of the messageSelector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageSelector(String value) {
        this.messageSelector = value;
    }

    /**
     * Gets the value of the pollingInterval property.
     * 
     */
    public long getPollingInterval() {
        return pollingInterval;
    }

    /**
     * Sets the value of the pollingInterval property.
     * 
     */
    public void setPollingInterval(long value) {
        this.pollingInterval = value;
    }

    /**
     * Gets the value of the acknowledgeMode property.
     * 
     */
    public int getAcknowledgeMode() {
        return acknowledgeMode;
    }

    /**
     * Sets the value of the acknowledgeMode property.
     * 
     */
    public void setAcknowledgeMode(int value) {
        this.acknowledgeMode = value;
    }

}