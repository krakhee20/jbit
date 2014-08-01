
package org.jitterbit.connector.framework.pojo.execute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataResponse;


/**
 * <p>Java class for executeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="activityMetadataResponse" type="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeResponse", propOrder = {
    "activityName",
    "activityMetadataResponse"
})
public class ExecuteResponse {

    @XmlElement(required = true)
    protected String activityName;
    @XmlElement(required = true)
    protected ActivityMetadataResponse activityMetadataResponse;

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
     * Gets the value of the activityMetadataResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityMetadataResponse }
     *     
     */
    public ActivityMetadataResponse getActivityMetadataResponse() {
        return activityMetadataResponse;
    }

    /**
     * Sets the value of the activityMetadataResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityMetadataResponse }
     *     
     */
    public void setActivityMetadataResponse(ActivityMetadataResponse value) {
        this.activityMetadataResponse = value;
    }

}
