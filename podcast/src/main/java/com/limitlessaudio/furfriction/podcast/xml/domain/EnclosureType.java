package com.limitlessaudio.furfriction.podcast.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**<p>The enclosure contains media data within an item.</p>
 * The &lt;enclosure> tag has three attributes: URL, length, and type. An enclosure from the example feed above is:
 * <pre>
 * &lt;enclosure url="http://furfriction.com/items/episode01.mp3" length="1024" type=“audio/mpeg"/>
 * </pre>
 * Java class for enclosureType complex type.
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;complexType name="enclosureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="url" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="length" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * iTunes supported enclosures:
 * <pre>
 * File Type
 * MP3  audio/mpeg
 * M4A  audio/x-m4a
 * MP4  video/mp4
 * M4V  video/x-m4v
 * MOV  ideo/quicktime
 * PDF  application/pdf
 * EPUB document/x-epub
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enclosureType")
public class EnclosureType {

    @XmlAttribute(name = "url", required = true)
    private String url;
    @XmlAttribute(name = "length", required = true)
    private int length;
    @XmlAttribute(name = "type", required = true)
    private String type;

    /**The URL attribute points to the podcast content. The file extension specified
     * within the URL attribute determines whether that content will appear in the
     * podcast directory. Supported file formats include M4A, MP3, MOV, MP4, M4V, PDF, and EPUB.
     * Getter method returns {@link String } object.
     * @return url is {@link String }
     */
    public String getUrl() {
        return url;
    }

    /**The URL attribute points to the podcast content. The file extension specified
     * within the URL attribute determines whether that content will appear in the
     * podcast directory. Supported file formats include M4A, MP3, MOV, MP4, M4V, PDF, and EPUB.
     * Setter method accepts {@link String} as parameter
     * @param url the url to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**The length attribute is the file size in bytes.
     * Getter method returns {@link Integer } object.
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**The length attribute is the file size in bytes.
     * Setter method accepts {@link Integer} as parameter
     * @param length the length to set
     */
    public void setLength(final int length) {
        this.length = length;
    }

    /**The type attribute provides the correct category for the type of file you are using.
     * The type values for supported file formats are as follows:
     * <pre>
     * File Type
     * MP3  audio/mpeg
     * M4A  audio/x-m4a
     * MP4  video/mp4
     * M4V  video/x-m4v
     * MOV  ideo/quicktime
     * PDF  application/pdf
     * EPUB document/x-epub
     * </pre>
     * Getter method returns {@link String } object.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**The type attribute provides the correct category for the type of file you are using.
     * The type values for supported file formats are as follows:
     * <pre>
     * File Type
     * MP3  audio/mpeg
     * M4A  audio/x-m4a
     * MP4  video/mp4
     * M4V  video/x-m4v
     * MOV  ideo/quicktime
     * PDF  application/pdf
     * EPUB document/x-epub
     * </pre>
     *  Setter method accepts {@link String} as parameter
     * @param type the type to set
     */
    public void setType(final String type) {
        this.type = type;
    }

}
