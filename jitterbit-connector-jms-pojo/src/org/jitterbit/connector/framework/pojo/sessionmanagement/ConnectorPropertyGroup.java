
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="connectorPropertyGroup" type="{http://www.jitterbit.com/connectorframework/sessionmgmt}connectorPropertyGroup"/>
 *         &lt;element name="connectorProperties" type="{http://www.jitterbit.com/connectorframework/sessionmgmt}connectorProperties"/>
 *       &lt;/sequence>
 *       &lt;attribute name="connectorPropertyGroupName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectorPropertyGroup", propOrder = {
    "connectorPropertyGroup",
    "connectorProperties"
})
public class ConnectorPropertyGroup {

    @XmlElement(required = true)
    protected ConnectorPropertyGroup connectorPropertyGroup;
    @XmlElement(required = true)
    protected ConnectorProperties connectorProperties;
    @XmlAttribute(name = "connectorPropertyGroupName")
    protected String connectorPropertyGroupName;

    /**
     * Gets the value of the connectorPropertyGroup property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectorPropertyGroup }
     *     
     */
    public ConnectorPropertyGroup getConnectorPropertyGroup() {
        return connectorPropertyGroup;
    }

    /**
     * Sets the value of the connectorPropertyGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectorPropertyGroup }
     *     
     */
    public void setConnectorPropertyGroup(ConnectorPropertyGroup value) {
        this.connectorPropertyGroup = value;
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

    /**
     * Gets the value of the connectorPropertyGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorPropertyGroupName() {
        return connectorPropertyGroupName;
    }

    /**
     * Sets the value of the connectorPropertyGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorPropertyGroupName(String value) {
        this.connectorPropertyGroupName = value;
    }

}
