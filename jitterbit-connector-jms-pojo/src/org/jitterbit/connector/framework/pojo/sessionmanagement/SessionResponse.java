
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionId1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sessionId2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sessionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sessionId1",
    "sessionId2",
    "sessionKey"
})
@XmlRootElement(name = "sessionResponse")
public class SessionResponse {

    @XmlElement(required = true)
    protected String sessionId1;
    @XmlElement(required = true)
    protected String sessionId2;
    protected String sessionKey;

    /**
     * Gets the value of the sessionId1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId1() {
        return sessionId1;
    }

    /**
     * Sets the value of the sessionId1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId1(String value) {
        this.sessionId1 = value;
    }

    /**
     * Gets the value of the sessionId2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId2() {
        return sessionId2;
    }

    /**
     * Sets the value of the sessionId2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId2(String value) {
        this.sessionId2 = value;
    }

    /**
     * Gets the value of the sessionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * Sets the value of the sessionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionKey(String value) {
        this.sessionKey = value;
    }

}
