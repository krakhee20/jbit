
package org.jitterbit.connector.framework.pojo.execute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataRequest;


/**
 * <p>Java class for executeRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executeRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="activityMetadataRequest" type="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeRequest", propOrder = {
    "activityName",
    "activityMetadataRequest"
})
@XmlSeeAlso({
    AsynchronousRequestStructure.class
})
public class ExecuteRequest {

    @XmlElement(required = true)
    protected String activityName;
    @XmlElement(required = true)
    protected ActivityMetadataRequest activityMetadataRequest;

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
     * Gets the value of the activityMetadataRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityMetadataRequest }
     *     
     */
    public ActivityMetadataRequest getActivityMetadataRequest() {
        return activityMetadataRequest;
    }

    /**
     * Sets the value of the activityMetadataRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityMetadataRequest }
     *     
     */
    public void setActivityMetadataRequest(ActivityMetadataRequest value) {
        this.activityMetadataRequest = value;
    }

}
