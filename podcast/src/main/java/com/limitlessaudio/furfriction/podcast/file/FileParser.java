package com.limitlessaudio.furfriction.podcast.file;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    }

    private void validate() {
        validateFileExists();
        validateIsDirectory();
        listDirectory();
    }

    private void listDirectory() {
        File[] files = file.listFiles();
        for (File f : files) {
            logger.debug(f.getAbsolutePath());
        }

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
