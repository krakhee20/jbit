
package org.jitterbit.connector.framework.pojo.metadata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="activity" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="applicationDomain" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="activityType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "activity"
})
@XmlRootElement(name = "activityListResponse")
public class ActivityListResponse {

    protected List<ActivityListResponse.Activity> activity;

    /**
     * Gets the value of the activity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityListResponse.Activity }
     * 
     * 
     */
    public List<ActivityListResponse.Activity> getActivity() {
        if (activity == null) {
            activity = new ArrayList<ActivityListResponse.Activity>();
        }
        return this.activity;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="applicationDomain" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="activityType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Activity {

        @XmlAttribute(name = "activityName")
        protected String activityName;
        @XmlAttribute(name = "applicationDomain")
        protected String applicationDomain;
        @XmlAttribute(name = "activityType")
        protected String activityType;

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
         * Gets the value of the applicationDomain property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplicationDomain() {
            return applicationDomain;
        }

        /**
         * Sets the value of the applicationDomain property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplicationDomain(String value) {
            this.applicationDomain = value;
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

    }

}
