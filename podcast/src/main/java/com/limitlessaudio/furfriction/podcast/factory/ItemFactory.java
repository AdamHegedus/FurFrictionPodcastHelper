package com.limitlessaudio.furfriction.podcast.factory;

import com.limitlessaudio.furfriction.podcast.mp3.domain.Id3v2Data;
import com.limitlessaudio.furfriction.podcast.xml.ItemType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesCategoryType;

/**Creates {@link ItemType} items.
 * @author x
 */
public class ItemFactory {

    /**Returns new {@link ItemType}.
     * @param data {@link Id3v2Data} contains the ID3 data
     * @return the instantiated new object
     */
    public ItemType getItem(final Id3v2Data data) {
        ItemType item = new ItemType();
        item.setAuthor(data.getArtist());
        item.setItunesAuthor(data.getArtist());
        item.setItunesDuration(data.getDurationFormatted());
        item.setTitle(data.getTitle());
        item.setItunesSubtitle(data.getItunesSubtitle());
        item.setItunesSummary(data.getCommentAsCData());
        item.setItunesCategory(new ItunesCategoryType("Music"));
        item.setDescription(data.getCommentAsCData());

        return item;
    }
}
