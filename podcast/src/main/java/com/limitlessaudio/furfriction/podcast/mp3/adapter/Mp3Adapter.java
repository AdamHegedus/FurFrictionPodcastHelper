package com.limitlessaudio.furfriction.podcast.mp3.adapter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

/**Wrapper class for com.mpatric.mp3agic third party library.
 * @author adam_hegedus
 */
public class Mp3Adapter implements Mp3 {

    private Logger logger = LoggerFactory.getLogger(Mp3Adapter.class);

    private String album = "";
    private String artist = "";
    private String comment = "";
    private String title = "";
    private String trackNumber = "0";
    private long duration;
    private long filesize;

    /**Gets the album field.
     * @return the album
     */
    @Override
    public String getAlbum() {
        return album;
    }

    /**Gets the artist field.
     * @return the artist
     */
    @Override
    public String getArtist() {
        return artist;
    }

    /**Gets the comment field.
     * @return the comment
     */
    @Override
    public String getComment() {
        return comment;
    }

    /**Gets the title.
     * @return the title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**Gets the track number as {@link String}.
     * @return the trackNumber
     */
    @Override
    public String getTrackNumber() {
        return trackNumber;
    }

    /**Gets the duration in long.
     * @return the duration
     */
    @Override
    public long getDuration() {
        return duration;
    }

    /**Gets the filesize in long.
     * @return the filesize
     */
    @Override
    public long getFilesize() {
        return filesize;
    }

    /**Get Mp3Wrapper objects from given file.
     * @param filename the filename to get parsed
     */
    public void processMp3(final String filename) {
        Mp3File file;
        try {
            file = new Mp3File(filename);
            duration = file.getLengthInSeconds();
            filesize = file.getLength();

            if (file.hasId3v2Tag()) {
                processId3v2(file.getId3v2Tag());
            }

            if (file.hasId3v1Tag()) {
                processId3v1(file.getId3v1Tag());
            }
        } catch (UnsupportedTagException e) {
            logger.warn(e.toString());
        } catch (InvalidDataException e) {
            logger.warn(e.toString());
        } catch (IOException e) {
            logger.warn(e.toString());
        }
    }

    private void processId3v2(final ID3v2 id3) {
        album = id3.getAlbum();
        logger.debug("id3v2 album: " + album);
        artist = id3.getArtist();
        logger.debug("id3v2 artist: " + artist);
        comment = id3.getComment();
        logger.debug("id3v2 comment: " + comment);
        title = id3.getTitle();
        logger.debug("id3v2 title: " + title);
        trackNumber = id3.getTrack();
        logger.debug("id3v2 track: " + trackNumber);
    }

    private void processId3v1(final ID3v1 id3) {
        album = id3.getAlbum();
        logger.debug("id3v2 album: " + album);
        artist = id3.getArtist();
        logger.debug("id3v1 artist: " + artist);
        comment = id3.getComment();
        logger.debug("id3v1 comment: " + comment);
        title = id3.getTitle();
        logger.debug("id3v1 title: " + title);
        trackNumber = id3.getTrack();
        logger.debug("id3v1 track: " + trackNumber);
    }
}
