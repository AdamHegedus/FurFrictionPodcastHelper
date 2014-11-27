package com.limitlessaudio.furfriction.podcast.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.limitlessaudio.furfriction.podcast.mp3.adapter.Mp3Adapter;
import com.limitlessaudio.furfriction.podcast.mp3.domain.Id3Data;
import com.limitlessaudio.furfriction.podcast.xml.domain.ItemType;
import com.limitlessaudio.furfriction.podcast.xml.factory.ItemFactory;

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
        } catch (IOException e) {
            logger.warn(e.toString());
        }
    }

    private void validate() {
        validateFileExists();
        validateIsDirectory();

    }

    /**Gets the parsed data from Mp3 files and creates an item skeleton.
     * @return item skeleton
     * @param filename Filename of the mp3
     */
    public ItemType getParsedItemSkeleton(final String filename) {
        ItemFactory factory = new ItemFactory("http://furfriction.com/podcast/");
        ItemType item;

        Mp3Adapter adapter = new Mp3Adapter();
        adapter.processMp3(filename);

        Id3Data data = new Id3Data();
        data.setAlbum(adapter.getAlbum());
        data.setArtist(adapter.getArtist());
        data.setComment(adapter.getComment());
        data.setDuration(adapter.getDuration());
        data.setFilesize(adapter.getFilesize());
        data.setTitle(adapter.getTitle());
        data.setTrackNumber(adapter.getTrackNumber());
        item = factory.getItem(data);

        return item;
    }

    public List<ItemType> getItems(final String filename) {
        List<ItemType> result = new ArrayList<ItemType>();
        List<String> files;
        try {
            files = listDirectory();
            for (String file : files) {
                result.add(getParsedItemSkeleton(file));
            }
        } catch (IOException e) {
            logger.warn(e.toString());
        }

        return result;
    }

    private List<String> listDirectory() throws IOException {
        File[] files = file.listFiles();
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < files.length; i++) {
            result.add(files[i].toString());
        }

        return result;
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
