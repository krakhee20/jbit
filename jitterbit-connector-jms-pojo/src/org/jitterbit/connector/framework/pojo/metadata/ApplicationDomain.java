
package org.jitterbit.connector.framework.pojo.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for applicationDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicationDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicationDomain" type="{http://www.jitterbit.com/connectorframework/metadata}applicationDomain"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="childDomainsPresent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicationDomain", propOrder = {
    "applicationDomain"
})
public class ApplicationDomain {

    @XmlElement(required = true)
    protected ApplicationDomain applicationDomain;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "childDomainsPresent")
    protected Boolean childDomainsPresent;

    /**
     * Gets the value of the applicationDomain property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationDomain }
     *     
     */
    public ApplicationDomain getApplicationDomain() {
        return applicationDomain;
    }

    /**
     * Sets the value of the applicationDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationDomain }
     *     
     */
    public void setApplicationDomain(ApplicationDomain value) {
        this.applicationDomain = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the childDomainsPresent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChildDomainsPresent() {
        return childDomainsPresent;
    }

    /**
     * Sets the value of the childDomainsPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChildDomainsPresent(Boolean value) {
        this.childDomainsPresent = value;
    }

}
