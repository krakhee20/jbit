
package org.jitterbit.connector.framework.pojo.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for activityMetadataResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="activityMetadataResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="schema" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="parentAppDomain" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="activityType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="direction" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="output" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activityMetadataResponse", propOrder = {
    "schema"
})
public class ActivityMetadataResponse {

    @XmlElement(required = true)
    protected Object schema;
    @XmlAttribute(name = "activityName")
    protected String activityName;
    @XmlAttribute(name = "parentAppDomain")
    protected String parentAppDomain;
    @XmlAttribute(name = "activityType")
    protected String activityType;
    @XmlAttribute(name = "direction", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String direction;

    /**
     * Gets the value of the schema property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSchema(Object value) {
        this.schema = value;
    }

    /**
     * Gets the value of the activityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Sets the value of the activityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityName(String value) {
        this.activityName = value;
    }

    /**
     * Gets the value of the parentAppDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentAppDomain() {
        return parentAppDomain;
    }

    /**
     * Sets the value of the parentAppDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentAppDomain(String value) {
        this.parentAppDomain = value;
    }

    /**
     * Gets the value of the activityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * Sets the value of the activityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityType(String value) {
        this.activityType = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        if (direction == null) {
            return "output";
        } else {
            return direction;
        }
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

}
