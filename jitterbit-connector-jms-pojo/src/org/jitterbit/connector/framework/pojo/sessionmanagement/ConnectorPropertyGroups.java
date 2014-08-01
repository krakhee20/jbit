
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for connectorPropertyGroups complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="connectorPropertyGroups">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connectorPropertyGroup" type="{http://www.jitterbit.com/connectorframework/sessionmgmt}connectorPropertyGroup" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectorPropertyGroups", propOrder = {
    "connectorPropertyGroup"
})
public class ConnectorPropertyGroups {

    @XmlElement(required = true)
    protected List<ConnectorPropertyGroup> connectorPropertyGroup;

    /**
     * Gets the value of the connectorPropertyGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectorPropertyGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectorPropertyGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConnectorPropertyGroup }
     * 
     * 
     */
    public List<ConnectorPropertyGroup> getConnectorPropertyGroup() {
        if (connectorPropertyGroup == null) {
            connectorPropertyGroup = new ArrayList<ConnectorPropertyGroup>();
        }
        return this.connectorPropertyGroup;
    }

}
