package com.limitlessaudio.furfriction.podcast.xml.domain.itunes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**<p>The &lt;itunes:owner> tag contains contact information for the owner of the podcast
 * intended to be used for administrative communication about the podcast.</p>
 * <p>The email address of the owner should be included in a nested &lt;itunes:email> element.
 * Include the name of the owner in a nested &lt;itunes:name> element.</p>
 * <p>The following schema fragment specifies the expected content contained within
 * this class.</p>
 * <pre>
 * &lt;complexType name="itunesOwnerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}email"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itunesOwnerType", propOrder = {"name", "email"})
public class ItunesOwnerType {
    @XmlElement(required = true, namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String name;
    @XmlElement(required = true, namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String email;

    /**Gets the name of the itunesOwner.
     * The method returns the name attribute as {@link String} object.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**Sets the name of the itunesOwner.
     * Setter method accepts {@link String} as parameter.
     * @param name
     *            allowed object is {@link String }
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the email of the itunesOwner.
     * The method returns the email attribute as {@link String} object.
     * @return email is {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**Sets the email of the itunesOwner.
     * Setter method accepts {@link String} as parameter.
     * @param email
     *            allowed object is {@link String }
     */
    public void setEmail(final String email) {
        this.email = email;
    }
}
