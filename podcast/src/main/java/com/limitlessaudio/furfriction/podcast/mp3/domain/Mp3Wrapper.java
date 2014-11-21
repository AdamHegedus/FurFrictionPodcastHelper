package com.limitlessaudio.furfriction.podcast.mp3.domain;

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
public class Mp3Wrapper {

    private Logger logger = LoggerFactory.getLogger(Mp3Wrapper.class);

    private String album = "";
    private String artist = "";
    private String comment = "";
    private String title = "";
    private String trackNumber = "0";
    private long duration;
    private long filesize;
    private Id3Data data;

    /**Get {@link Id3Data} objects from given file.
     * @param filename the filename to get parsed
     * @return Id3Data
     */
    public Id3Data getMp3Data(final String filename) {
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
        data = new Id3Data();
        setupId3Data();

        return data;

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

    private void setupId3Data() {
        data.setAlbum(album);
        data.setArtist(artist);
        data.setComment(comment);
        data.setDuration(duration);
        data.setFilesize(filesize);
        data.setTitle(title);
        data.setTrackNumber(trackNumber);
    }
}
