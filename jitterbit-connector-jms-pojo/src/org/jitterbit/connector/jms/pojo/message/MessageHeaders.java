
package org.jitterbit.connector.jms.pojo.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageHeaders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageHeaders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JMSCorrelationID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JMSDeliveryMode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="JMSDestination" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JMSExpiration" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="JMSMessageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JMSPriority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="JMSRedelivered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="JMSReplyTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JMSTimestamp" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="JMSType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageHeaders", propOrder = {
    "jmsCorrelationID",
    "jmsDeliveryMode",
    "jmsDestination",
    "jmsExpiration",
    "jmsMessageID",
    "jmsPriority",
    "jmsRedelivered",
    "jmsReplyTo",
    "jmsTimestamp",
    "jmsType"
})
public class MessageHeaders {

    @XmlElement(name = "JMSCorrelationID", required = true)
    protected String jmsCorrelationID;
    @XmlElement(name = "JMSDeliveryMode")
    protected int jmsDeliveryMode;
    @XmlElement(name = "JMSDestination", required = true)
    protected String jmsDestination;
    @XmlElement(name = "JMSExpiration")
    protected long jmsExpiration;
    @XmlElement(name = "JMSMessageID", required = true)
    protected String jmsMessageID;
    @XmlElement(name = "JMSPriority")
    protected int jmsPriority;
    @XmlElement(name = "JMSRedelivered")
    protected boolean jmsRedelivered;
    @XmlElement(name = "JMSReplyTo", required = true)
    protected String jmsReplyTo;
    @XmlElement(name = "JMSTimestamp")
    protected long jmsTimestamp;
    @XmlElement(name = "JMSType", required = true)
    protected String jmsType;

    /**
     * Gets the value of the jmsCorrelationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMSCorrelationID() {
        return jmsCorrelationID;
    }

    /**
     * Sets the value of the jmsCorrelationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJMSCorrelationID(String value) {
        this.jmsCorrelationID = value;
    }

    /**
     * Gets the value of the jmsDeliveryMode property.
     * 
     */
    public int getJMSDeliveryMode() {
        return jmsDeliveryMode;
    }

    /**
     * Sets the value of the jmsDeliveryMode property.
     * 
     */
    public void setJMSDeliveryMode(int value) {
        this.jmsDeliveryMode = value;
    }

    /**
     * Gets the value of the jmsDestination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMSDestination() {
        return jmsDestination;
    }

    /**
     * Sets the value of the jmsDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJMSDestination(String value) {
        this.jmsDestination = value;
    }

    /**
     * Gets the value of the jmsExpiration property.
     * 
     */
    public long getJMSExpiration() {
        return jmsExpiration;
    }

    /**
     * Sets the value of the jmsExpiration property.
     * 
     */
    public void setJMSExpiration(long value) {
        this.jmsExpiration = value;
    }

    /**
     * Gets the value of the jmsMessageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMSMessageID() {
        return jmsMessageID;
    }

    /**
     * Sets the value of the jmsMessageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJMSMessageID(String value) {
        this.jmsMessageID = value;
    }

    /**
     * Gets the value of the jmsPriority property.
     * 
     */
    public int getJMSPriority() {
        return jmsPriority;
    }

    /**
     * Sets the value of the jmsPriority property.
     * 
     */
    public void setJMSPriority(int value) {
        this.jmsPriority = value;
    }

    /**
     * Gets the value of the jmsRedelivered property.
     * 
     */
    public boolean isJMSRedelivered() {
        return jmsRedelivered;
    }

    /**
     * Sets the value of the jmsRedelivered property.
     * 
     */
    public void setJMSRedelivered(boolean value) {
        this.jmsRedelivered = value;
    }

    /**
     * Gets the value of the jmsReplyTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMSReplyTo() {
        return jmsReplyTo;
    }

    /**
     * Sets the value of the jmsReplyTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJMSReplyTo(String value) {
        this.jmsReplyTo = value;
    }

    /**
     * Gets the value of the jmsTimestamp property.
     * 
     */
    public long getJMSTimestamp() {
        return jmsTimestamp;
    }

    /**
     * Sets the value of the jmsTimestamp property.
     * 
     */
    public void setJMSTimestamp(long value) {
        this.jmsTimestamp = value;
    }

    /**
     * Gets the value of the jmsType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMSType() {
        return jmsType;
    }

    /**
     * Sets the value of the jmsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJMSType(String value) {
        this.jmsType = value;
    }

}
