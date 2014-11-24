package com.limitlessaudio.furfriction.podcast.mp3.adapter;

/**Adapter for getting ID3 data from mp3 files.
 * @author adam_hegedus
 */
public interface Mp3 {

    /**Gets the album.
     * @return the album
     */
    String getAlbum();

    /**Gets the artist.
     * @return the artist
     */
    String getArtist();

    /**Gets the comment.
     * @return the comment
     */
    String getComment();

    /**Gets the title.
     * @return the title
     */
    String getTitle();

    /**Gets the track number.
     * @return the track number
     */
    String getTrackNumber();

    /**Gets the duration in seconds.
     * @return the duration
     */
    long getDuration();

    /**Gets the filesize in bytes.
     * @return the filesize
     */
    long getFilesize();
}
