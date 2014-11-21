package com.limitlessaudio.furfriction.podcast.xml.factory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.limitlessaudio.furfriction.podcast.mp3.domain.Id3Data;
import com.limitlessaudio.furfriction.podcast.xml.domain.EnclosureType;
import com.limitlessaudio.furfriction.podcast.xml.domain.ItemType;
import com.limitlessaudio.furfriction.podcast.xml.domain.itunes.ItunesCategoryType;
import com.limitlessaudio.furfriction.podcast.xml.domain.itunes.ItunesImageType;

/**Creates {@link ItemType} items.
 * @author x
 */
public class ItemFactory {

    private final String url;

    /**Sets the url to the default base for further processing.
     * @param url the url to set
     */
    public ItemFactory(final String url) {
        this.url = url;
    }

    /**Returns new {@link ItemType}.
     * @param data {@link Id3Data} contains the ID3 data
     * @return the instantiated new object
     */
    public ItemType getItem(final Id3Data data) {
        final ItemType item = new ItemType();
        item.setAuthor(data.getArtist());
        item.setItunesAuthor(data.getArtist());
        item.setItunesDuration(data.getDurationFormatted());
        item.setTitle(data.getTitle());
        item.setItunesSubtitle(data.getItunesSubtitle());
        item.setItunesSummary(data.getComment());
        item.setItunesCategory(new ItunesCategoryType("Music"));
        item.setDescription(data.getComment());
        final String guid = url
                + "episodes/"
                + encodeURI(data.getAlbum() + " " + data.getTrackNumberFormattedToThreeCharacter() + " " + data.getArtist() + " - " + data.getTitle()
                        + ".mp3");
        item.setGuid(guid);
        item.setLink(guid);
        final EnclosureType enclosure = new EnclosureType();
        enclosure.setType("audio/mpeg");
        enclosure.setLength((int) data.getFilesize());
        enclosure.setUrl(guid);
        item.setEnclosure(enclosure);
        final String imageLink = url + "episodes/" + encodeURI(data.getTrackNumberFormattedToThreeCharacter() + " " + data.getAlbum() + ".jpg");
        item.setItunesImage(new ItunesImageType(imageLink));

        return item;
    }

    /**Reads input text and returns URI encoded {@link String}.
     * @param textToEncodeAsUri is {@link String}
     * @return result is {@link String}
     */
    public String encodeURI(final String textToEncodeAsUri) {
        String result;

        try {
            result = URLEncoder.encode(textToEncodeAsUri, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            result = textToEncodeAsUri;
        }

        return result;
    }

}
