
package org.jitterbit.connector.framework.pojo.sessionmanagement;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for endpoint.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="endpoint">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JMS"/>
 *     &lt;enumeration value="NetSuite"/>
 *     &lt;enumeration value="SugarCRM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "endpoint")
@XmlEnum
public enum Endpoint {

    JMS("JMS"),
    @XmlEnumValue("NetSuite")
    NET_SUITE("NetSuite"),
    @XmlEnumValue("SugarCRM")
    SUGAR_CRM("SugarCRM");
    private final String value;

    Endpoint(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Endpoint fromValue(String v) {
        for (Endpoint c: Endpoint.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
