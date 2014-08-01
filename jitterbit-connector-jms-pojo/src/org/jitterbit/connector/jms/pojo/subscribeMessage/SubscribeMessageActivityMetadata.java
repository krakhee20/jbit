
package org.jitterbit.connector.jms.pojo.subscribeMessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subscribeMessageActivityMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscribeMessageActivityMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="topicName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="durableSubscription" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="clientID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="durableSubscriptionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageSelector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="receiveTimeout" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "subscribeMessageActivityMetadata", propOrder = {
    "topicName",
    "durableSubscription",
    "clientID",
    "durableSubscriptionName",
    "messageType",
    "messageSelector",
    "receiveTimeout",
    "acknowledgeMode"
})
public class SubscribeMessageActivityMetadata {

    @XmlElement(required = true)
    protected String topicName;
    protected boolean durableSubscription;
    @XmlElement(required = true)
    protected String clientID;
    @XmlElement(required = true)
    protected String durableSubscriptionName;
    @XmlElement(required = true)
    protected String messageType;
    @XmlElement(required = true)
    protected String messageSelector;
    protected long receiveTimeout;
    protected int acknowledgeMode;

    /**
     * Gets the value of the topicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * Sets the value of the topicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopicName(String value) {
        this.topicName = value;
    }

    /**
     * Gets the value of the durableSubscription property.
     * 
     */
    public boolean isDurableSubscription() {
        return durableSubscription;
    }

    /**
     * Sets the value of the durableSubscription property.
     * 
     */
    public void setDurableSubscription(boolean value) {
        this.durableSubscription = value;
    }

    /**
     * Gets the value of the clientID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * Sets the value of the clientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientID(String value) {
        this.clientID = value;
    }

    /**
     * Gets the value of the durableSubscriptionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDurableSubscriptionName() {
        return durableSubscriptionName;
    }

    /**
     * Sets the value of the durableSubscriptionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDurableSubscriptionName(String value) {
        this.durableSubscriptionName = value;
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
     * Gets the value of the receiveTimeout property.
     * 
     */
    public long getReceiveTimeout() {
        return receiveTimeout;
    }

    /**
     * Sets the value of the receiveTimeout property.
     * 
     */
    public void setReceiveTimeout(long value) {
        this.receiveTimeout = value;
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
