package com.limitlessaudio.furfriction.podcast.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for imageType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;complexType name="imageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}url"/>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}link"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imageType", propOrder = {"url", "title", "link"})
public class ImageType {

    @XmlElement(required = true)
    private String url;
    @XmlElement(required = true)
    private String title;
    @XmlElement(required = true)
    private String link;

    /**
     * Gets the value of the url property.
     * @return url is {@link String }
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * @param url
     *            allowed object is {@link String }
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the value of the title property.
     * @return title is {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * @param title
     *            allowed object is {@link String }
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value of the link property.
     * @return link is {@link String }
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * @param link
     *            allowed object is {@link String }
     */
    public void setLink(String link) {
        this.link = link;
    }

}
