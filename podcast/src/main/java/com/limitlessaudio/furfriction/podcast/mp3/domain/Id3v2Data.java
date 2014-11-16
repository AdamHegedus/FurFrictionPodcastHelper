package com.limitlessaudio.furfriction.podcast.mp3.domain;

/**Bean class to handle MP3.
 * @author x
 */
public class Id3v2Data {

    private static final int CHARACTER_LENGTH_IS_ONE = 1;
    private static final int CHARACTER_LENGTH_IS_TWO = 2;
    private static final int SECONDS_IN_HOUR = Integer.valueOf(3600);
    private static final int MINUTES_IN_HOUR = Integer.valueOf(60);
    private String artist;
    private String album;
    private String title;
    private String comment;
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
    public void setArtist(String artist) {
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
    public void setAlbum(String album) {
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
    public void setTitle(String title) {
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
    public void setComment(String comment) {
        this.comment = comment;
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
    public void setDuration(long duration) {
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
            result += addLeadingZeroIfLessThanTen(getDurationMinutes() + "") + ":";
        }
        result += addLeadingZeroIfLessThanTen(getDurationSeconds() + "");
        return result;
    }

    private String addLeadingZeroIfLessThanTen(final String text) {
        return text.length() < CHARACTER_LENGTH_IS_TWO ? "0" + text : text;
    }

    private boolean isLessThanOneHour() {
        return duration < SECONDS_IN_HOUR;
    }

    private boolean isLessThanOneMinute() {
        return duration < MINUTES_IN_HOUR;
    }

    private int getDurationHours() {
        final int hours = (int) (duration / SECONDS_IN_HOUR);
        return hours;
    }

    private int getDurationMinutes() {
        final int minutes = (int) (duration % SECONDS_IN_HOUR) / MINUTES_IN_HOUR;
        return minutes;
    }

    private int getDurationSeconds() {
        final int seconds = (int) (duration % MINUTES_IN_HOUR);
        return seconds;
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
    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    /**Gets the track number field formatted as 3 letter, pre-zeroed like 007.
     * @return the trackNumber
     */
    public String getTrackNumberFormattedToThreeCharacter() {
        String result = "";

        switch (trackNumber.length()) {
        case CHARACTER_LENGTH_IS_TWO:
            result = "0" + trackNumber;
            break;

        case CHARACTER_LENGTH_IS_ONE:
            result = "00" + trackNumber;
            break;

        default:
            result = trackNumber;
            break;
        }
        return result;
    }

}
