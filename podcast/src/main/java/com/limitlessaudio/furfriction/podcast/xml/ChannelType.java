package com.limitlessaudio.furfriction.podcast.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.limitlessaudio.furfriction.podcast.xml.atom.AtomLinkType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesCategoryType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesImageType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesOwnerType;

/**<p>Root element of the podcast. The following schema fragment specifies the expected
 * content contained within this class.</p>
 * <pre>
 * &lt;complexType name="channelType">
 *  &lt;complexContent>
 *      &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *          &lt;sequence>
 *              &lt;element ref="{}docs"/>
 *              &lt;element ref="{}title"/>
 *              &lt;element ref="{}description"/>
 *              &lt;element ref="{}link"/>
 *              &lt;element ref="{}language"/>
 *              &lt;element ref="{}copyright"/>
 *              &lt;element ref="{}managingEditor"/>
 *              &lt;element ref="{}webMaster"/>
 *              &lt;element ref="{}pubDate"/>
 *              &lt;element ref="{}lastBuildDate"/>
 *              &lt;element ref="{}category"/>
 *              &lt;element ref="{}ttl"/>
 *              &lt;element name="image" type="{}imageType"/>
 *              &lt;element ref="{}itunes:author"/>
 *              &lt;element ref="{}itunes:subtitle"/>
 *              &lt;element ref="{}itunes:summary"/>
 *              &lt;element name="itunes:category" type="{}itunesCategoryType"/>
 *              &lt;element name="itunes:image" type="{}itunesImageType"/>
 *              &lt;element ref="{}itunes:explicit"/>
 *              &lt;element name="itunes:owner" type="{}itunesOwnerype"/>
 *              &lt;element name="item" type="{}itemType" maxOccurs="unbounded"/>
 *          &lt;/sequence>
 *      &lt;/restriction>
 *  &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "channelType", propOrder = {"atomLink", "docs", "title", "description", "link", "language", "copyright", "managingEditor",
    "webMaster", "pubDate", "lastBuildDate", "category", "ttl", "image", "itunesAuthor", "itunesSubtitle", "itunesSummary", "itunesCategory",
    "itunesImage", "itunesExplicit", "itunesOwner", "item"})
public class ChannelType {
    @XmlElement(required = true, name = "link", namespace = "http://www.w3.org/2005/Atom")
    private AtomLinkType atomLink;
    @XmlElement(required = true)
    private String title;
    @XmlElement(required = true)
    private String description;
    @XmlElement(required = true)
    private String link;
    @XmlElement(required = true)
    private List<ItemType> item;
    @XmlElement
    private String language;
    @XmlElement
    private String copyright;
    @XmlElement
    private String managingEditor;
    @XmlElement
    private String webMaster;
    @XmlElement
    private String pubDate;
    @XmlElement
    private String lastBuildDate;
    @XmlElement
    private String category;
    @XmlElement
    private String docs;
    @XmlElement
    private int ttl;
    @XmlElement
    private ImageType image;
    @XmlElement(required = true, name = "author", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesAuthor;
    @XmlElement(required = true, name = "subtitle", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesSubtitle;
    @XmlElement(required = true, name = "summary", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesSummary;
    @XmlElement(required = true, name = "category", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private ItunesCategoryType itunesCategory;
    @XmlElement(required = true, name = "image", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private ItunesImageType itunesImage;
    @XmlElement(required = true, name = "explicit", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private String itunesExplicit;
    @XmlElement(required = true, name = "owner", namespace = "http://www.itunes.com/dtds/podcast-1.0.dtd")
    private ItunesOwnerType itunesOwner;

    /**The &lt;atom:link> element defines a relationship between a web resource (such
     * as a page) and an RSS channel or item (optional).
     * @return atomLink is {@link AtomLinkType }
     */
    public AtomLinkType getAtomLink() {
        return atomLink;
    }

    /**The &lt;atom:link> element defines a relationship between a web resource (such
     * as a page) and an RSS channel or item (optional). Setter method accepts
     * {@link AtomLinkType} as parameter.
     * @param atomLink the atomLink to set
     */
    public void setAtomLink(AtomLinkType atomLink) {
        this.atomLink = atomLink;
    }

    /**The name of the channel.
     * @return title is {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**The name of the channel.
     * @param title allowed object is {@link String }
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**The URL to the HTML website corresponding to the channel.
     * @return link is {@link String }
     */
    public String getLink() {
        return link;
    }

    /**The URL to the HTML website corresponding to the channel.
     * @param link allowed object is {@link String }
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**The language the channel is written in. Only values from the ISO 639 list
     * (two-letter language codes, with some possible modifiers, such as
     * “en-us") are supported.
     * @return language is {@link String }
     */
    public String getLanguage() {
        return language;
    }

    /**The language the channel is written in. Only values from the ISO 639 list
     * (two-letter language codes, with some possible modifiers, such as
     * “en-us") are supported.
     * @param language allowed object is {@link String }
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**Phrase or sentence describing the channel.
     * @return description is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**Phrase or sentence describing the channel.
     * @param description allowed object is {@link String }
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**This tag specifies the date and time when the last episode was released.
     * The format for the content should be per RFC 2822, for example:
     * <pre>
     * Wed, 15
     * Jun 2014 19:00:00 GMT
     * </pre>
     * Getter method returns {@link String} object.
     * @return pubDate is {@link String }
     */
    public String getPubDate() {
        return pubDate;
    }

    /**This tag specifies the date and time when the last episode was released.
     * The format for the content should be per RFC 2822, for example:
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

    /**Gets the value of the image property.
     * @return image is {@link ImageType }
     */
    public ImageType getImage() {
        return image;
    }

    /**Sets the value of the image property.
     * @param image allowed object is {@link ImageType }
     */
    public void setImage(ImageType image) {
        this.image = image;
    }

    /**Copyright notice for content in the channel.
     * @return copyright is {@link String }
     */
    public String getCopyright() {
        return copyright;
    }

    /**Copyright notice for content in the channel.
     * @param copyright allowed object is {@link String }
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**The item property is the main content of the podcast, the feed can has
     * multiple items.
     * <p>This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the item property. For example, to add a new item, do as follows:</p>
     * <pre>
     * getItem().add(newItem);
     * </pre>
     * Objects of the following type(s) are allowed in the list {@link ItemType }
     * @return item
     */
    public List<ItemType> getItem() {
        if (item.isEmpty()) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    /**<p>The &lt;itunes:author> tag contains contact information for the editor of
     * the podcast intended to be used for communication about the podcast's
     * content. If &lt;itunes:author> is not present at the RSS podcast feed
     * level, iTunes will use the contents of &lt;managingEditor>.</p>
     * Getter method returns {@link String} object.
     * @return itunesAuthor is {@link String }
     */
    public String getItunesAuthor() {
        return itunesAuthor;
    }

    /**<p>The &lt;itunes:author> tag contains contact information for the editor of
     * the podcast intended to be used for communication about the podcast's
     * content. If &lt;itunes:author> is not present at the RSS podcast feed
     * level, iTunes will use the contents of &lt;managingEditor>.</p>
     * Setter method accepts {@link String} as parameter.
     * @param itunesAuthor the itunesAuthor to set
     */
    public void setItunesAuthor(String itunesAuthor) {
        this.itunesAuthor = itunesAuthor;
    }

    /**<p>The contents of the &lt;itunes:subtitle> tag are displayed in the
     * Description column in iTunes.</p>
     * Getter method returns {@link String} object.
     * @return itunesSubtitle is {@link String }
     */
    public String getItunesSubtitle() {
        return itunesSubtitle;
    }

    /**<p>The contents of the &lt;itunes:subtitle> tag are displayed in the
     * Description column in iTunes.</p>
     * Setter method accepts {@link String} as parameter.
     * @param itunesSubtitle the itunesSubtitle to set
     */
    public void setItunesSubtitle(String itunesSubtitle) {
        this.itunesSubtitle = itunesSubtitle;
    }

    /**<p>The contents of the &lt;itunes:summary> tag are shown on the iTunes Store
     * page for the podcast. The information also appears in a separate window
     * if the information (“i”) icon in the Description column is clicked. This
     * field can be up to 4000 characters. If a &lt;itunes:summary> tag is not
     * included, the contents of the &lt;description> tag are used.</p>
     * Getter method returns {@link String} object.
     * @return itunesSummary is {@link String }
     */
    public String getItunesSummary() {
        return itunesSummary;
    }

    /**<p>The contents of the &lt;itunes:summary> tag are shown on the iTunes Store
     * page for the podcast. The information also appears in a separate window
     * if the information (“i”) icon in the Description column is clicked. This
     * field can be up to 4000 characters. If a &lt;itunes:summary> tag is not
     * included, the contents of the &lt;description> tag are used.</p>
     * Setter method accepts {@link String} as parameter.
     * @param itunesSummary the itunesSummary to set
     */
    public void setItunesSummary(String itunesSummary) {
        this.itunesSummary = itunesSummary;
    }

    /**The &lt;itunes:explicit> tag indicates whether the podcast contains
     * explicit material. The two usable values for this tag are “yes” and
     * “clean”.
     * <p>The value “yes” indicates the presence of explicit content, therefore in
     * iTunes an “explicit” parental advisory graphic will appear.</p>
     * <p>The value “clean” indicates that none of the podcast episodes contain
     * explicit language or adult content, in iTunes a “clean” parental advisory
     * graphic will appear.</p>
     * <p>Any other value besides “yes” or “clean” results in neither of the
     * parental advisory graphics will appear and that space will remain blank.</p>
     * Getter method returns {@link String} object.
     * @return itunesExplicit is {@link String }
     */
    public String getItunesExplicit() {
        return itunesExplicit;
    }

    /**The &lt;itunes:explicit> tag indicates whether the podcast contains
     * explicit material. The two usable values for this tag are “yes” and
     * “clean”.
     * <p>The value “yes” indicates the presence of explicit content, therefore in
     * iTunes an “explicit” parental advisory graphic will appear.</p>
     * <p>The value “clean” indicates that none of the podcast episodes contain
     * explicit language or adult content, in iTunes a “clean” parental advisory
     * graphic will appear.</p>
     * <p>Any other value besides “yes” or “clean” results in neither of the
     * parental advisory graphics will appear and that space will remain blank.</p>
     * Setter method accepts {@link String} as parameter.
     * @param itunesExplicit the itunesExplicit to set
     */
    public void setItunesExplicit(String itunesExplicit) {
        this.itunesExplicit = itunesExplicit;
    }

    /**The &lt;itunes:owner> tag contains contact information for the owner of
     * the podcast intended to be used for administrative communication about
     * the podcast.
     * Getter method returns {@link ItunesOwnerType} object.
     * @return itunesOwner is {@link ItunesOwnerType }
     */
    public ItunesOwnerType getItunesOwner() {
        return itunesOwner;
    }

    /**The &lt;itunes:owner> tag contains contact information for the owner of
     * the podcast intended to be used for administrative communication about
     * the podcast.
     * Setter method accepts {@link ItunesOwnerType} as parameter.
     * @param itunesOwner the itunesOwner to set.
     */
    public void setItunesOwner(ItunesOwnerType itunesOwner) {
        this.itunesOwner = itunesOwner;
    }

    /**The &lt;managindEditor> tag contains contact information for the editor
     * of the podcast intended to be used for communication about the podcast's
     * content.
     * Getter method returns {@link String} object.
     * @return the managingEditor
     */
    public String getManagingEditor() {
        return managingEditor;
    }

    /**The &lt;managindEditor> tag contains contact information for the editor
     * of the podcast intended to be used for communication about the podcast's
     * content.
     * Setter method accepts {@link String} as parameter.
     * @param managingEditor the managingEditor to set
     */
    public void setManagingEditor(String managingEditor) {
        this.managingEditor = managingEditor;
    }

    /**The &lt;webMaster> tag contains contact information for the owner of the
     * podcast intended to be used for administrative communication about the
     * podcast.
     * Getter method returns {@link String} object.
     * @return the webMaster
     */
    public String getWebMaster() {
        return webMaster;
    }

    /**The &lt;webMaster> tag contains contact information for the owner of the
     * podcast intended to be used for administrative communication about the
     * podcast.
     * Setter method accepts {@link String} as parameter.
     * @param webMaster the webMaster to set
     */
    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }

    /**This tag specifies the date and time when the podcast xml file was last
     * changed. The format for the content should be per RFC 2822, for example:
     * <pre>
     * Wed, 15
     * Jun 2014 19:00:00 GMT
     * </pre>
     * Getter method returns {@link String} object.
     * @return the lastBuildDate
     */
    public String getLastBuildDate() {
        return lastBuildDate;
    }

    /**This tag specifies the date and time when the podcast xml file was last
     * changed. The format for the content should be per RFC 2822, for example:
     * <pre>
     * Wed, 15
     * Jun 2014 19:00:00 GMT
     * </pre>
     * Setter method accepts {@link String} as parameter.
     * @param lastBuildDate the lastBuildDate to set
     */
    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    /**Specify one or more categories that the channel belongs to. Different
     * from RSS 2.0 specification. Getter method returns {@link String} object.
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**Specify one or more categories that the channel belongs to. Different
     * from RSS 2.0 specification. Setter method accepts {@link String} as
     * parameter.
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**The ttl stands for time to live. It's a number of minutes that indicates
     * how long a channel can be cached before refreshing from the source.
     * Getter method returns {@link Integer} object.
     * @return the ttl
     */
    public int getTtl() {
        return ttl;
    }

    /**The ttl stands for time to live. It's a number of minutes that indicates
     * how long a channel can be cached before refreshing from the source.
     * Setter method accepts {@link Integer} as parameter.
     * @param ttl the ttl to set
     */
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    /**The &lt;itunes:category> tag points to the category of the podcast.
     * Getter method returns {@link ItunesCategoryType} object.
     * @return the itunesCategory
     */
    public ItunesCategoryType getItunesCategory() {
        return itunesCategory;
    }

    /**The &lt;itunes:category> tag points to the category of the podcast.
     * Setter method accepts {@link ItunesCategoryType} as parameter.
     * @param itunesCategory the itunesCategory to set
     */
    public void setItunesCategory(ItunesCategoryType itunesCategory) {
        this.itunesCategory = itunesCategory;
    }

    /**The &lt;itunes:image> tag points to the artwork of the podcast. Getter
     * method returns {@link ItunesImageType} object.
     * @return the itunesImage
     */
    public ItunesImageType getItunesImage() {
        return itunesImage;
    }

    /**The &lt;itunes:image> tag points to the artwork of the podcast. Setter
     * method accepts {@link ItunesImageType} as parameter.
     * @param itunesImage the itunesImage to set
     */
    public void setItunesImage(ItunesImageType itunesImage) {
        this.itunesImage = itunesImage;
    }
}
