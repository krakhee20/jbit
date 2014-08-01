
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for connectorProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="connectorProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connectorPropertyName" type="{http://www.jitterbit.com/connectorframework/sessionmgmt}connectorProperty"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectorProperties", propOrder = {
    "connectorPropertyName"
})
public class ConnectorProperties {

    @XmlElement(required = true)
    protected ConnectorProperty connectorPropertyName;

    /**
     * Gets the value of the connectorPropertyName property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectorProperty }
     *     
     */
    public ConnectorProperty getConnectorPropertyName() {
        return connectorPropertyName;
    }

    /**
     * Sets the value of the connectorPropertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectorProperty }
     *     
     */
    public void setConnectorPropertyName(ConnectorProperty value) {
        this.connectorPropertyName = value;
    }

}
