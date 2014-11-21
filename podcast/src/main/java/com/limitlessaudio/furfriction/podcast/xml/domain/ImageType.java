package com.limitlessaudio.furfriction.podcast.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**<p>The &lt;image> tag points to the artwork of the podcast, via the URL
 * specified in the &lt;a href> attribute.</p>
 * <p>Cover art must be in the JPEG or PNG file formats and in the RGB color space
 * with a minimum size of 1400 x 1400 pixels and a maximum size of 2048 x 2048
 * pixels. Note that these requirements are different from the standard RSS
 * image tag specification.</p>
 *<pre>
 * &lt;image href="http://furfriction.com/image.jpg" />
 * </pre>
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

    /**The url attribute is representing the URI of the image.
     * @return url is {@link String }
     */
    public String getUrl() {
        return url;
    }

    /**The url attribute is representing the URI of the image.
     * @param url allowed object is {@link String }
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**The title describes the image, it's used in the ALT attribute of the HTML
     * &lt;img> tag when the channel is rendered in HTML.
     * @return title is {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**The title describes the image, it's used in the ALT attribute of the HTML
     * &lt;img> tag when the channel is rendered in HTML.
     * @param title allowed object is {@link String }
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**The link is the URL of the site, when the channel is rendered, the image
     * is a link to the site. (In practice the image &lt;title> and &lt;link>
     * should have the same value as the channel's &lt;title> and &lt;link>
     * @return link is {@link String }
     */
    public String getLink() {
        return link;
    }

    /**The link is the URL of the site, when the channel is rendered, the image
     * is a link to the site. (In practice the image &lt;title> and &lt;link>
     * should have the same value as the channel's &lt;title> and &lt;link>
     * @param link allowed object is {@link String }
     */
    public void setLink(final String link) {
        this.link = link;
    }
}
