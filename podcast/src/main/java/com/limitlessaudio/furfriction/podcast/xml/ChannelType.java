package com.limitlessaudio.furfriction.podcast.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.limitlessaudio.furfriction.podcast.xml.atom.AtomLinkType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesCategoryType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesImageType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesOwnerType;

/**
 * <p>
 * Java class for channelType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="channelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}docs"/>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}link"/>
 *         &lt;element ref="{}language"/>
 *         &lt;element ref="{}copyright"/>
 *         &lt;element ref="{}managingEditor"/>
 *         &lt;element ref="{}webMaster"/>
 *         &lt;element ref="{}pubDate"/>
 *         &lt;element ref="{}lastBuildDate"/>
 *         &lt;element ref="{}category"/>
 *         &lt;element ref="{}ttl"/>
 *         &lt;element name="image" type="{}imageType"/>
 *         &lt;element ref="{}itunes:author"/>
 *         &lt;element ref="{}itunes:subtitle"/>
 *         &lt;element ref="{}itunes:summary"/>
 *         &lt;element name="itunes:category" type="{}itunesCategoryType"/>
 *         &lt;element name="itunes:image" type="{}itunesImageType"/>
 *         &lt;element ref="{}itunes:explicit"/>
 *         &lt;element name="itunes:owner" type="{}itunesOwnerype"/>
 *         &lt;element name="item" type="{}itemType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "channelType", propOrder = {"atomLink", "docs", "title", "description", "link", "language", "copyright", "managingEditor",
    "webMaster", "pubDate", "lastBuildDate", "category", "ttl", "image", "itunesAuthor", "itunesSubtitle", "itunesSummary", "itunesCategory",
    "itunesImage", "itunesExplicit", "itunesOwner", "item"})
public class ChannelType {

    // the required tags for the channel item
    @XmlElement(required = true, name = "link", namespace = "http://www.w3.org/2005/Atom")
    private AtomLinkType atomLink;
    @XmlElement(required = true)
    private String title;
    @XmlElement(required = true)
    private String description;
    @XmlElement(required = true)
    private String link;
    @XmlElement(required = true)
    private ArrayList<ItemType> item;

    // the optional tags for the channel item
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

    // the iTunes specific tags for the channel item
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

    /**
     * Gets the value of the title property.
     * 
     * @return atomLink is {@link AtomLinkType }
     */
    public AtomLinkType getAtomLink() {
        return atomLink;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param atomLink
     *            allowed object is {@link AtomLinkType }
     * 
     */
    public void setAtomLink(AtomLinkType atomLink) {
        this.atomLink = atomLink;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return title is {@link String }
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param title
     *            allowed object is {@link String }
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return link is {@link String }
     * 
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param link
     *            allowed object is {@link String }
     * 
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return language is {@link String }
     * 
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param language
     *            allowed object is {@link String }
     * 
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return description is {@link String }
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param description
     *            allowed object is {@link String }
     * 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the value of the pubDate property.
     * 
     * @return pubDate is {@link String }
     * 
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * Sets the value of the pubDate property.
     * 
     * @param pubDate
     *            allowed object is {@link String }
     * 
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return image is {@link ImageType }
     * 
     */
    public ImageType getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param image
     *            allowed object is {@link ImageType }
     * 
     */
    public void setImage(ImageType image) {
        this.image = image;
    }

    /**
     * Gets the value of the copyright property.
     * 
     * @return copyright is {@link String }
     * 
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Sets the value of the copyright property.
     * 
     * @param copyright
     *            allowed object is {@link String }
     * 
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link ItemType }
     * 
     * 
     */
    public ArrayList<ItemType> getItem() {
        if (item == null) {
            item = new ArrayList<ItemType>();
        }
        return this.item;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return itunesAuthor is {@link String }
     * 
     */
    public String getItunesAuthor() {
        return itunesAuthor;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param itunesAuthor
     *            allowed object is {@link String }
     * 
     */
    public void setItunesAuthor(String itunesAuthor) {
        this.itunesAuthor = itunesAuthor;
    }

    /**
     * Gets the value of the itunesSubtitle property.
     * 
     * @return itunesSubtitle is {@link String }
     */
    public String getItunesSubtitle() {
        return itunesSubtitle;
    }

    /**
     * Sets the value of the itunesSubtitle property.
     * 
     * @param itunesSubtitle
     *            allowed object is {@link String }
     */
    public void setItunesSubtitle(String itunesSubtitle) {
        this.itunesSubtitle = itunesSubtitle;
    }

    /**
     * Gets the value of the itunesSummary property.
     * 
     * @return itunesSummary is {@link String }
     */
    public String getItunesSummary() {
        return itunesSummary;
    }

    /**
     * 
     * Sets the value of the itunesSummary property.
     * 
     * @param itunesSummary
     *            allowed object is {@link String }
     */
    public void setItunesSummary(String itunesSummary) {
        this.itunesSummary = itunesSummary;
    }

    /**
     * Gets the value of the itunesExplicit property.
     * 
     * @return itunesExplicit is {@link String }
     */
    public String getItunesExplicit() {
        return itunesExplicit;
    }

    /**
     * Sets the value of the itunesExplicit property.
     * 
     * @param itunesExplicit
     *            allowed object is {@link String }
     */
    public void setItunesExplicit(String itunesExplicit) {
        this.itunesExplicit = itunesExplicit;
    }

    /**
     * Gets the value of the itunesOwner property.
     * 
     * @return itunesOwner is {@link ItunesOwnerType }
     */
    public ItunesOwnerType getItunesOwner() {
        return itunesOwner;
    }

    /**
     * Sets the value of the itunesOwner property.
     * 
     * @param itunesOwner
     *            allowed object is {@link ItunesOwnerType }
     */
    public void setItunesOwner(ItunesOwnerType itunesOwner) {
        this.itunesOwner = itunesOwner;
    }

    /**
     * @return the managingEditor
     */
    public String getManagingEditor() {
        return managingEditor;
    }

    /**
     * @param managingEditor
     *            the managingEditor to set
     */
    public void setManagingEditor(String managingEditor) {
        this.managingEditor = managingEditor;
    }

    /**
     * @return the webMaster
     */
    public String getWebMaster() {
        return webMaster;
    }

    /**
     * @param webMaster
     *            the webMaster to set
     */
    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }

    /**
     * @return the lastBuildDate
     */
    public String getLastBuildDate() {
        return lastBuildDate;
    }

    /**
     * @param lastBuildDate
     *            the lastBuildDate to set
     */
    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     *            the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * 
     * @return the ttl
     */
    public int getTtl() {
        return ttl;
    }

    /**
     * @param ttl
     *            the ttl to set
     */
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    /**
     * Gets the value of the itunesCategory property.
     * 
     * @return the itunesCategory
     */
    public ItunesCategoryType getItunesCategory() {
        return itunesCategory;
    }

    /**
     * @param itunesCategory
     *            the itunesCategory to set
     */
    public void setItunesCategory(ItunesCategoryType itunesCategory) {
        this.itunesCategory = itunesCategory;
    }

    /**
     * Gets the value of the itunesImage property.
     * 
     * @return the itunesImage
     */
    public ItunesImageType getItunesImage() {
        return itunesImage;
    }

    /**
     * @param itunesImage
     *            allowed object is {@link ItunesImageType }
     */
    public void setItunesImage(ItunesImageType itunesImage) {
        this.itunesImage = itunesImage;
    }

}
