package com.limitlessaudio.furfriction.podcast.file;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.limitlessaudio.furfriction.podcast.mp3.domain.Id3Data;
import com.limitlessaudio.furfriction.podcast.mp3.domain.Mp3Wrapper;
import com.limitlessaudio.furfriction.podcast.xml.domain.ItemType;
import com.limitlessaudio.furfriction.podcast.xml.factory.ItemFactory;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

/**Reads input files and parse Mp3 data from them.
 * @author adam_hegedus
 *
 */
public class FileParser {

    private Logger logger = LoggerFactory.getLogger(FileParser.class);
    private File file;

    /**Constructs the class object with the given parameter.
     * @param file the file to set
     */
    public FileParser(File file) {
        this.file = file;
    }

    /**Gets the file.
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**Sets the file to parse.
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**Checks if the file is a directory.
     */
    public void parseDirectory() {
        validate();
        try {
            listDirectory();
        } catch (UnsupportedTagException | InvalidDataException | IOException e) {
            logger.warn(e.toString());
        }
    }

    private void validate() {
        validateFileExists();
        validateIsDirectory();

    }

    /**Gets the parsed data from Mp3 files and creates an item skeleton.
     * @return item skeleton
     * @throws IOException
     * @throws InvalidDataException
     * @throws UnsupportedTagException
     * @param filename Filename of the mp3
     */
    public ItemType getParsedItemSkeleton(final String filename) throws UnsupportedTagException, InvalidDataException, IOException {
        ItemFactory factory = new ItemFactory("http://furfriction.com/podcast/");
        ItemType item;

        Mp3File mp3 = new Mp3File(filename);

        ID3v2 id3 = mp3.getId3v2Tag();
        Id3Data data = new Id3Data();
        Mp3Wrapper wrapper = new Mp3Wrapper();
        data = wrapper.getMp3Data(filename);

        //        String album = id3.getAlbum();
        //        String artist = id3.getArtist();
        //        String comment = id3.getComment();
        //        String title = id3.getTitle();
        //        String trackNumber = id3.getTrack();
        //        long duration = mp3.getLengthInSeconds();
        //        long filesize = mp3.getLength();
        //
        //        data.setAlbum(id3.getAlbum());
        //        data.setArtist(id3.getArtist());
        //        data.setComment(id3.getComment());
        //        data.setDuration(mp3.getLengthInSeconds());
        //        data.setTitle(id3.getTitle());
        //        data.setTrackNumber(id3.getTrack());
        //        data.setFilesize(mp3.getLength());

        item = factory.getItem(data);

        return item;
    }

    private void listDirectory() throws UnsupportedTagException, InvalidDataException, IOException {
        File[] files = file.listFiles();
    }

    private void validateFileExists() {
        if (!file.exists()) {
            logger.debug(file.getPath() + " is not a exist.");
            throw new RuntimeException(file.getPath() + " not found.");
        }
    }

    private void validateIsDirectory() {
        if (!file.isDirectory()) {
            logger.debug(file.getPath() + " is not a directory.");
            throw new RuntimeException(file.getPath() + "is not a directory.");
        }
    }

}
