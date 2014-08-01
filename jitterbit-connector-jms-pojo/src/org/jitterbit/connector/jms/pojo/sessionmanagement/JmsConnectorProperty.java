
package org.jitterbit.connector.jms.pojo.sessionmanagement;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jitterbit.connector.framework.pojo.sessionmanagement.ConnectorProperty;


/**
 * <p>Java class for jmsConnectorProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="jmsConnectorProperty">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.jitterbit.com/connectorframework/sessionmgmt}connectorProperty">
 *       &lt;sequence>
 *         &lt;element name="queue" type="{http://www.jitterbit.com/connectors/jms}queue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="topic" type="{http://www.jitterbit.com/connectors/jms}topic" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jmsConnectorProperty", propOrder = {
    "queue",
    "topic"
})
public class JmsConnectorProperty
    extends ConnectorProperty
{

    protected List<Queue> queue;
    protected List<Topic> topic;

    /**
     * Gets the value of the queue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the queue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQueue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Queue }
     * 
     * 
     */
    public List<Queue> getQueue() {
        if (queue == null) {
            queue = new ArrayList<Queue>();
        }
        return this.queue;
    }

    /**
     * Gets the value of the topic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Topic }
     * 
     * 
     */
    public List<Topic> getTopic() {
        if (topic == null) {
            topic = new ArrayList<Topic>();
        }
        return this.topic;
    }

}
