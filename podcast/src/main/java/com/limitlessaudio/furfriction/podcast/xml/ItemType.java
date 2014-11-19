package com.limitlessaudio.furfriction.podcast.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesCategoryType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesImageType;

/**<p>The item property is the main content of the podcast, the feed can has
 * multiple items. This Java class represents the "itemType" complex type in the
 * XML file.</p>
 * <p>The following schema fragment specifies the expected content contained within
 * this class.</p>
 * <pre>
 * &lt;complexType name="itemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}link"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}guid"/>
 *         &lt;element name="enclosure" type="{}enclosureType"/>
 *         &lt;element ref="{}pubDate"/>
 *         &lt;element ref="{}author"/>
 *         &lt;element ref="{}itunes:author"/>
 *         &lt;element ref="{}itunes:subtitle"/>
 *         &lt;element ref="{}itunes:summary"/>
 *         &lt;element ref="{}itunes:duration"/>
 *         &lt;element name="itunes:image" type="{}itunesImageType"/>
 *         &lt;element ref="{}itunes:author"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemType", propOrder = {"title", "link", "description", "guid", "enclosure", "pubDate", "author", "itunesAuthor", "itunesSubtitle",
    "itunesSummary", "itunesCategory", "itunesDuration", "itunesImage", "itunesExplicit"})
public class ItemType {

    // the required tags for the items
    @XmlElement(required = true)
    private String title;
    @XmlElement(required = true)
    private String link;
    @XmlElement(required = true)
    private String description;
    @XmlElement(required = true)
    private String guid;
    @XmlElement(required = true)
    private EnclosureType enclosure;
    @XmlElement(required = true)
    private String pubDate;

    // the optional tags for the items
    @XmlElement
    private String author;

    // the iTunes specific tags for the items
    @XmlElement(required = true, name = "author", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesAuthor;
    @XmlElement(required = true, name = "subtitle", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesSubtitle;
    @XmlElement(required = true, name = "summary", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    private String itunesSummary;
    @XmlElement(name = "category", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private ItunesCategoryType itunesCategory;
    @XmlElement(name = "duration", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesDuration;
    @XmlElement(required = true, name = "image", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private ItunesImageType itunesImage;
    @XmlElement(required = true, name = "explicit", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesExplicit;

    /**The title of the item.
     * Getter method returns {@link String} object.
     * @return title is {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**The title of the item.
     * Setter method accepts {@link String} as parameter.
     * @param title allowed object is {@link String }
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**The URL of the item.
     * Getter method returns {@link String} object.
     * @return link is {@link String }
     */
    public String getLink() {
        return link;
    }

    /**The URL of the item.
     * Setter method accepts {@link String} as parameter.
     * @param link allowed object is {@link String }
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**The item synopsis.
     * Getter method returns {@link String} object.
     * @return description is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**The item synopsis.
     * Setter method accepts {@link String} as parameter.
     * @param description allowed object is {@link String }
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**Every &lt;item> (episode) should have a permanent, case-sensitive GUID
     * (Globally Unique Identifier). When adding episodes to the RSS podcast
     * feed, GUIDs are compared in case-sensitive fashion to determine which
     * episodes are new. If GUID is not present, the episode URL will be used
     * instead. The GUID should be assigned to an episode only once and should
     * never change. Assigning new GUIDs to existing episodes may cause issues
     * with the podcast’s listing and chart placement in the iTunes Store.
     * @return the guid is {@link String}
     */
    public String getGuid() {
        return guid;
    }

    /**Every &lt;item> (episode) should have a permanent, case-sensitive GUID
     * (Globally Unique Identifier). When adding episodes to the RSS podcast
     * feed, GUIDs are compared in case-sensitive fashion to determine which
     * episodes are new. If GUID is not present, the episode URL will be used
     * instead. The GUID should be assigned to an episode only once and should
     * never change. Assigning new GUIDs to existing episodes may cause issues
     * with the podcast’s listing and chart placement in the iTunes Store.
     * @param guid the guid to set, allowed object is {@link String }
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**The enclosure contains media data within an item.
     * Getter method returns {@link EnclosureType} object.
     * @return the enclosure is {@link EnclosureType}
     */
    public EnclosureType getEnclosure() {
        return enclosure;
    }

    /**The enclosure contains media data within an item.
     * Setter method accepts {@link EnclosureType} as parameter.
     * @param enclosure the enclosure to set
     */
    public void setEnclosure(EnclosureType enclosure) {
        this.enclosure = enclosure;
    }

    /**This tag specifies the date and time when an episode was released. The
     * format for the content should be per RFC 2822, for example:
     * <pre>
     * Wed, 15
     * Jun 2014 19:00:00 GMT
     * </pre>
     * Getter method returns {@link String} object.
     * @return the pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**This tag specifies the date and time when an episode was released. The
     * format for the content should be per RFC 2822, for example:
     * <pre>
     * Wed, 15
     * Jun 2014 19:00:00 GMT
     * </pre>
     * Setter method accepts {@link String} as parameter.
     * @param pubDate the pubDate to set
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**Email address of the author of the item by RSS 2.0 specification.
     * Getter method returns {@link String} object.
     * @return the author is {@link String}
     */
    public String getAuthor() {
        return author;
    }

    /**Email address of the author of the item by RSS 2.0 specification.
     * Setter method accepts {@link String} as parameter.
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**The content of this tag is shown in the Artist column in iTunes. If the &lt;itunes:author>
     * tag is not present, iTunes uses the contents of the &lt;author> tag.
     * Getter method returns {@link String} object.
     * @return the itunesAuthor is {@link String}
     */
    public String getItunesAuthor() {
        return itunesAuthor;
    }

    /**The content of this tag is shown in the Artist column in iTunes. If the &lt;itunes:author>
     * tag is not present, iTunes uses the contents of the &lt;author> tag.
     * Setter method accepts {@link String} as parameter.
     * @param itunesAuthor the itunesAuthor to set
     */
    public void setItunesAuthor(String itunesAuthor) {
        this.itunesAuthor = itunesAuthor;
    }

    /**The contents of the &lt;itunes:subtitle> tag are displayed in the Description column in iTunes.
     * Getter method returns {@link String} object.
     * @return the itunesSubtitle
     */
    public String getItunesSubtitle() {
        return itunesSubtitle;
    }

    /**The contents of the &lt;itunes:subtitle> tag are displayed in the Description column in iTunes.
     * Setter method accepts {@link String} as parameter.
     * @param itunesSubtitle the itunesSubtitle to set
     */
    public void setItunesSubtitle(String itunesSubtitle) {
        this.itunesSubtitle = itunesSubtitle;
    }

    /**<p>The contents of the &lt;itunes:summary> tag are shown on the iTunes Store page for the podcast.
     * The information also appears in a separate window if the information (“i”) icon in the Description
     * column is clicked. This field can be up to 4000 characters.</p>
     * <p>If a &lt;itunes:summary> tag is not included, the contents of the &lt;description> tag are used.</p>
     * Getter method returns {@link String} object.
     * @return the itunesSummary
     */
    public String getItunesSummary() {
        return itunesSummary;
    }

    /**<p>The contents of the &lt;itunes:summary> tag are shown on the iTunes Store page for the podcast.
     * The information also appears in a separate window if the information (“i”) icon in the Description
     * column is clicked. This field can be up to 4000 characters.</p>
     * <p>If a &lt;itunes:summary> tag is not included, the contents of the &lt;description> tag are used.</p>
     * Setter method accepts {@link String} as parameter.
     * @param itunesSummary the itunesSummary to set
     */
    public void setItunesSummary(String itunesSummary) {
        this.itunesSummary = itunesSummary;
    }

    /**<p>The &lt;itunes:category> tag points to the category of the podcast item.</p>
     * Getter method returns {@link ItunesCategoryType} object.
     * @return the itunesCategory
     */
    public ItunesCategoryType getItunesCategory() {
        return itunesCategory;
    }

    /**<p>The &lt;itunes:category> tag points to the category of the podcast item.</p>
     * Setter method accepts {@link ItunesCategoryType} as parameter.
     * @param itunesCategory the itunesCategory to set
     */
    public void setItunesCategory(ItunesCategoryType itunesCategory) {
        this.itunesCategory = itunesCategory;
    }

    /**<p>The content of the &lt;itunes:duration> tag is shown in the Time column in the List View on iTunes.
     * The value provided for this tag can be formatted as HH:MM:SS, H:MM:SS, MM:SS, or M:SS,
     * where H = hours, M = minutes, S = seconds. If a single number is provided as a value (no colons are used),
     * the value is assumed to be in seconds. If one colon is present, the number to the left is assumed to be minutes,
     * and the number to the right is assumed to be seconds. If more than two colons are present,
     * the numbers farthest to the right are ignored.
     * </p>
     * Getter method returns {@link String} object.
     * @return the itunesDuration
     */
    public String getItunesDuration() {
        return itunesDuration;
    }

    /**<p>The content of the &lt;itunes:duration> tag is shown in the Time column in the List View on iTunes.
     * The value provided for this tag can be formatted as HH:MM:SS, H:MM:SS, MM:SS, or M:SS,
     * where H = hours, M = minutes, S = seconds. If a single number is provided as a value (no colons are used),
     * the value is assumed to be in seconds. If one colon is present, the number to the left is assumed to be minutes,
     * and the number to the right is assumed to be seconds. If more than two colons are present,
     * the numbers farthest to the right are ignored.
     * </p>
     * Setter method accepts {@link String} as parameter.
     * @param itunesDuration the itunesDuration to set
     */
    public void setItunesDuration(String itunesDuration) {
        this.itunesDuration = itunesDuration;
    }

    /**<p>The &lt;itunes:image> tag points to the artwork of the podcast item.</p>
     * Getter method returns {@link ItunesImageType} object.
     * @return the itunesImage
     */
    public ItunesImageType getItunesImage() {
        return itunesImage;
    }

    /**<p>The &lt;itunes:image> tag points to the artwork of the podcast item.</p>
     * Setter method accepts {@link ItunesImageType} as parameter.
     * @param itunesImage the itunesImage to set
     */
    public void setItunesImage(ItunesImageType itunesImage) {
        this.itunesImage = itunesImage;
    }

    /**The &lt;itunes:explicit> tag indicates whether the podcast episode
     * contains explicit material. The two usable values for this tag are “yes”
     * and “clean”.
     * Getter method returns {@link String} object.
     * @return the itunesExplicit is {@link String }
     */
    public String getItunesExplicit() {
        return itunesExplicit;
    }

    /**The &lt;itunes:explicit> tag indicates whether the podcast episode
     * contains explicit material. The two usable values for this tag are “yes”
     * and “clean”.
     * Setter method accepts {@link String} as parameter.
     * @param itunesExplicit the itunesExplicit to set
     */
    public void setItunesExplicit(String itunesExplicit) {
        this.itunesExplicit = itunesExplicit;
    }

}
