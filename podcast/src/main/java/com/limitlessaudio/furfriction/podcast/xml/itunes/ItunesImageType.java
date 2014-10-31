package com.limitlessaudio.furfriction.podcast.xml.itunes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**<p>The &lt;itunes:image> tag points to the artwork of the podcast, via the URL specified in the &lt;a href> attribute.</p>
 * <p>Cover art must be in the JPEG or PNG file formats and in the RGB color space with a minimum size of 1400 x 1400 pixels
 *  and a maximum size of 2048 x 2048 pixels.
 * Note that these requirements are different from the standard RSS image tag specification.</p>
 * <pre>
 * &lt;itunes:image href="http://furfriction.com/image.jpg" />
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itunesImageType", propOrder = {"href"})
public class ItunesImageType {
    @XmlAttribute(name = "href", required = true)
    private String href;

    /**The href attribute is representing the URI of the image.
     * Getter method returns {@link String} object.
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**The href attribute is representing the URI of the image.
     * Setter method accepts {@link String} as parameter
     * @param href the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }

}
