
package org.jitterbit.connector.jms.pojo.queueBrowser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.metadata.ActivityMetadataResponse;


/**
 * <p>Java class for queueBrowserResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queueBrowserResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/metadata}activityMetadataResponse">
 *       &lt;sequence>
 *         &lt;element name="numberOfMessages" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queueBrowserResponse", propOrder = {
    "numberOfMessages"
})
public class QueueBrowserResponse
    extends ActivityMetadataResponse
{

    protected int numberOfMessages;

    /**
     * Gets the value of the numberOfMessages property.
     * 
     */
    public int getNumberOfMessages() {
        return numberOfMessages;
    }

    /**
     * Sets the value of the numberOfMessages property.
     * 
     */
    public void setNumberOfMessages(int value) {
        this.numberOfMessages = value;
    }

}
