package com.limitlessaudio.furfriction.podcast.xml.domain.atom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**<p>The atom:link element defines a relationship between a web resource (such as a page) and an RSS channel or item (optional).
 * The most common use is to identify an HTML representation of an entry in an RSS or Atom feed.
 * </p>
 * Example:
 * <pre>
 * &lt;atom:link href="http://furfriction.com/rss.xml" rel="self" type="application/rss+xml" />
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atomicLinkType")
public class AtomLinkType {
    @XmlAttribute(name = "href", required = true)
    private String href;
    @XmlAttribute(name = "rel", required = true)
    private String rel;
    @XmlAttribute(name = "type", required = true)
    private String type;

    /**Empty.
     */
    public AtomLinkType() {
        super();
    }

    /**Constructor sets members default to "self" and "application/rss+xml" with the given parameter as "href".
     * @param href is {@link String}, the xml file's URI
     */
    public AtomLinkType(final String href) {
        this.href = href;
        this.rel = "self";
        this.type = "application/rss+xml";
    }

    /**The href attribute is representing the URI of the links.
     * Getter method returns {@link String} object.
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**The href attribute is representing the URI of the links.
     * Setter method accepts {@link String} as parameter.
     * @param href
     *            the href to set
     */
    public void setHref(final String href) {
        this.href = href;
    }

    /**<p>The element may contain a rel attribute, which contains a keyword that identifies the nature of the relationship between the linked resource and the element.
     * Five relationships are possible:</p>
     * self:<br>
     * - describes the feed itself (most likely used by in this case for the podcast)<br>
     * alternate:<br>
     * - describes an alternate representation, such as a web page containing the same content as a feed entry<br>
     * enclosure:<br>
     * - describes a a media object such as an audio or video file<br>
     * related:<br>
     * - describes a related resource<br>
     * via:<br>
     * - describes the original source that authored the entry, when it's not the feed publisher<br>
     * <p>
     * The method returns the rel attribute as {@link String} object.
     * </p>
     * @return the rel
     */
    public String getRel() {
        return rel;
    }

    /**The type attribute identifies the resource's MIME media type.
     * This method returns the type attribute as {@link String} object.
     * @return the type
     */
    public String getType() {
        return type;
    }

}
