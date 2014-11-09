package com.limitlessaudio.furfriction.podcast.xml.itunes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**<p>The &lt;itunes:category> tag points to the category of the podcast, via the URL specified in the text attribute.</p>
 * <p>This class represents only the single 'old' category type, not the newer which apple has introduced later.
 * It is most likely that you may use the attribute value "Music".</p>
 * Example:
 * <pre>
 * &lt;itunes:category text="Music" />
 * </pre>
 * More info can be found in this website: {@link specs https://www.apple.com/itunes/podcasts/specs.html#category}
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itunesCategoryType", propOrder = {"text"})
public class ItunesCategoryType {
    @XmlAttribute(name = "text", required = true)
    private String text;
    
    public ItunesCategoryType() {
        this.text = "Music";
    }

    /**The text attribute is representing the category of the item.
     * Getter method returns {@link String} object.
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**The text attribute is representing the category of the item.
     * Setter method accepts {@link String} as parameter.
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}
