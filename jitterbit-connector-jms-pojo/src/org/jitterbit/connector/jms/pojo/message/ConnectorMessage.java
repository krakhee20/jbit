
package org.jitterbit.connector.jms.pojo.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for connectorMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="connectorMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="messageHeaders" type="{http://www.jitterbit.com/connectors/jms/message}messageHeaders"/>
 *         &lt;element name="customMessageProperties" type="{http://www.jitterbit.com/connectors/jms/message}customMessagePropertyList"/>
 *         &lt;element name="messageBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectorMessage", propOrder = {
    "messageHeaders",
    "customMessageProperties",
    "messageBody"
})
public class ConnectorMessage {

    @XmlElement(required = true)
    protected MessageHeaders messageHeaders;
    @XmlElement(required = true)
    protected CustomMessagePropertyList customMessageProperties;
    @XmlElement(required = true)
    protected String messageBody;

    /**
     * Gets the value of the messageHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaders }
     *     
     */
    public MessageHeaders getMessageHeaders() {
        return messageHeaders;
    }

    /**
     * Sets the value of the messageHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaders }
     *     
     */
    public void setMessageHeaders(MessageHeaders value) {
        this.messageHeaders = value;
    }

    /**
     * Gets the value of the customMessageProperties property.
     * 
     * @return
     *     possible object is
     *     {@link CustomMessagePropertyList }
     *     
     */
    public CustomMessagePropertyList getCustomMessageProperties() {
        return customMessageProperties;
    }

    /**
     * Sets the value of the customMessageProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomMessagePropertyList }
     *     
     */
    public void setCustomMessageProperties(CustomMessagePropertyList value) {
        this.customMessageProperties = value;
    }

    /**
     * Gets the value of the messageBody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageBody() {
        return messageBody;
    }

    /**
     * Sets the value of the messageBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageBody(String value) {
        this.messageBody = value;
    }

}
