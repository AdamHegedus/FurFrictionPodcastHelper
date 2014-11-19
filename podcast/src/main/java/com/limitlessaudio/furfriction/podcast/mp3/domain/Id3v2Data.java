package com.limitlessaudio.furfriction.podcast.mp3.domain;

/**Bean class to handle MP3.
 * @author x
 */
public class Id3v2Data {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int SECONDS_IN_HOUR = Integer.valueOf(3600);
    private static final int MINUTES_IN_HOUR = Integer.valueOf(60);
    private String artist = "";
    private String album = "";
    private String title = "";
    private String comment = " ";
    private long duration;
    private String trackNumber = "0";

    /**Gets the artist field.
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**Sets the artist field by given parameter.
     * @param artist the artist to set
     */
    public void setArtist(final String artist) {
        this.artist = artist;
    }

    /**Gets the album field.
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**Sets the album field by given parameter.
     * @param album the album to set
     */
    public void setAlbum(final String album) {
        this.album = album;
    }

    /**Gets the title field.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**Sets the title field by given parameter.
     * @param title the title to set
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**Gets the comment section.
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**Sets the comment field by given parameter.
     * @param comment the comment to set
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**Gets the comments in CDATA.
     * @return the comment formatted
     */
    public String getCommentAsCData() {
        String commentCData = "<![CDATA[" + comment + "]]>";
        return commentCData;
    }

    /**Gets the duration of the track.
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**Sets the duration by the given parameter.
     * @param duration the duration to set
     */
    public void setDuration(final long duration) {
        this.duration = duration;
    }

    /**Gets the duration of the track formatted as HH:mm:ss.
     * @return the formatted duration as {@link String}
     */
    public String getDurationFormatted() {

        String result = "";

        if (!isLessThanOneMinute()) {
            if (!isLessThanOneHour()) {
                result += getDurationHours() + ":";
            }
            result += addLeadingZeroIfLessThanTen(Integer.toString(getDurationMinutes())) + ":";
        }
        result += addLeadingZeroIfLessThanTen(Integer.toString(getDurationSeconds()));
        return result;
    }

    private String addLeadingZeroIfLessThanTen(final String text) {
        return text.length() < TWO ? "0" + text : text;
    }

    private boolean isLessThanOneHour() {
        return duration < SECONDS_IN_HOUR;
    }

    private boolean isLessThanOneMinute() {
        return duration < MINUTES_IN_HOUR;
    }

    private int getDurationHours() {
        return (int) (duration / SECONDS_IN_HOUR);
    }

    private int getDurationMinutes() {
        return (int) (duration % SECONDS_IN_HOUR) / MINUTES_IN_HOUR;
    }

    private int getDurationSeconds() {
        return (int) (duration % MINUTES_IN_HOUR);
    }

    /**Gets the track number field.
     * @return the trackNumber
     */
    public String getTrackNumber() {
        return trackNumber;
    }

    /**Sets the track number field by given parameter.
     * @param trackNumber the trackNumber to set
     */
    public void setTrackNumber(final String trackNumber) {
        this.trackNumber = trackNumber;
    }

    /**Gets the track number field formatted as 3 letter, pre-zeroed like 007.
     * @return the trackNumber
     */
    public String getTrackNumberFormattedToThreeCharacter() {
        String result;

        switch (trackNumber.length()) {
        case TWO:
            result = "0" + trackNumber;
            break;

        case ONE:
            result = "00" + trackNumber;
            break;

        default:
            result = trackNumber;
            break;
        }
        return result;
    }

    private String getAlbumAsUpperCase() {
        return this.getAlbum().toUpperCase();
    }

    /**Gets the itunesSubtitle parameter as {@link String} created by UpperCase Album property + pre-zeroed tracknumber.
     * @return itunesSubtitle
     */
    public String getItunesSubtitle() {
        String itunesSubtitle = getAlbumAsUpperCase() + " " + getTrackNumberFormattedToThreeCharacter();
        return itunesSubtitle;
    }
}
