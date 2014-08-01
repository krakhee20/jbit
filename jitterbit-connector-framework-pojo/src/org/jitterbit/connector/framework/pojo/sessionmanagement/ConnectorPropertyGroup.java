
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for connectorPropertyGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="connectorPropertyGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="propertyGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="connectorProperties" type="{http://www.jitterbit.com/connectorframework/sessionmgmt}connectorProperties"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectorPropertyGroup", propOrder = {
    "propertyGroupName",
    "connectorProperties"
})
public class ConnectorPropertyGroup {

    @XmlElement(required = true)
    protected String propertyGroupName;
    @XmlElement(required = true)
    protected ConnectorProperties connectorProperties;

    /**
     * Gets the value of the propertyGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyGroupName() {
        return propertyGroupName;
    }

    /**
     * Sets the value of the propertyGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyGroupName(String value) {
        this.propertyGroupName = value;
    }

    /**
     * Gets the value of the connectorProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectorProperties }
     *     
     */
    public ConnectorProperties getConnectorProperties() {
        return connectorProperties;
    }

    /**
     * Sets the value of the connectorProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectorProperties }
     *     
     */
    public void setConnectorProperties(ConnectorProperties value) {
        this.connectorProperties = value;
    }

}
