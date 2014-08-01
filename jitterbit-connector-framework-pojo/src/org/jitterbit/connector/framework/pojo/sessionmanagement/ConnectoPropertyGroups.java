
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for connectoPropertyGroups complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="connectoPropertyGroups">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connectorPropertyGroup" type="{http://www.jitterbit.com/connectorframework/sessionmgmt}connectorPropertyGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectoPropertyGroups", propOrder = {
    "connectorPropertyGroup"
})
public class ConnectoPropertyGroups {

    @XmlElement(required = true)
    protected ConnectorPropertyGroup connectorPropertyGroup;

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

}
