package com.limitlessaudio.furfriction.podcast.xml.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**<p>The class represents a custom RSS xml file. It is based on iTunes specification,
 *  standard RSS specification and includes atom:link tags to fulfill the needs.
 *  </p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="channel" type="{}channelType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="2.0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"channel"})
@XmlRootElement(name = "rss")
public class RssType {

    @XmlElement(required = true)
    private ChannelType channel;
    @XmlAttribute(name = "version", required = true)
    private String version;

    /**Default empty constructor for JAXB operations.
     */
    public RssType() {
        super();
    }

    /**Constructor to set channel data.
     * @param channel the channel to set
     */
    public RssType(final ChannelType channel) {
        this.channel = channel;
        this.version = "2.0";
    }

    /**The channel attribute is the real root element of a podcast feed.
     * It represents the channel element and the items.
     * Getter method returns {@link ChannelType } object.
     * @return channel
     */
    public ChannelType getChannel() {
        return channel;
    }

    /**The channel attribute is the real root element of a podcast feed.
     * It represents the channel element and the items.
     * Setter method accepts {@link ChannelType} as parameter
     * @param channel the channel to set
     */
    public void setChannel(final ChannelType channel) {
        this.channel = channel;
    }
}
