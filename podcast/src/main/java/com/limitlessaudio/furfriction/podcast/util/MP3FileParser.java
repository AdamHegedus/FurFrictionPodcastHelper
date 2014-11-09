package com.limitlessaudio.furfriction.podcast.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.limitlessaudio.furfriction.podcast.xml.EnclosureType;
import com.limitlessaudio.furfriction.podcast.xml.ItemType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesCategoryType;
import com.limitlessaudio.furfriction.podcast.xml.itunes.ItunesImageType;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

/**This utility class is used to parse mp3 files to get data for further processing.
  */
public final class MP3FileParser {

    private static Logger logger = LoggerFactory.getLogger(MP3FileParser.class);

    private MP3FileParser() {

    }

    
    public static ItemType getItemSkeletonFromAudioFile(final String filename) throws UnsupportedTagException, InvalidDataException, IOException{
        Mp3File file = new Mp3File(filename);
        ItemType item = new ItemType();
        ID3v2 id3 = getID3v2(file);
        item.setAuthor(id3.getArtist());
        item.setItunesSummary(id3.getComment());
        item.setItunesAuthor(id3.getArtist());
        item.setPubDate(DateConverter.convertDateToRFC2822(new Date()));
        
        ItunesCategoryType itunesCategory = new ItunesCategoryType();
        itunesCategory.setText("Music");
        item.setItunesCategory(itunesCategory);
        item.setItunesExplicit("Clean");
        item.setTitle(id3.getTitle());
        
        String description = id3.getAlbum().toUpperCase() + " 00" + id3.getTrack();
        item.setDescription(description);
        item.setItunesSubtitle(description);
        
        String duration = file.getLengthInSeconds() + "";
        logger.debug(filename + " Duration before : " + duration);
        duration = getDuration((int)file.getLengthInSeconds());
        item.setItunesDuration(duration);
        logger.debug(filename + " Duration after : " + duration);
        
        String guid = id3.getAlbum().toUpperCase() + " 00" + id3.getTrack() + " " + id3.getArtist() + " - " + id3.getTitle() + ".mp3";
        item.setGuid("http://furfriction.com/podcast/episodes/" + encodeURI(guid));
        item.setLink("http://furfriction.com/podcast/episodes/" + encodeURI(guid));
        
        EnclosureType enclosure = new EnclosureType();
        enclosure.setType("audio/mpeg");
        enclosure.setUrl("http://furfriction.com/podcast/episodes/" + encodeURI(guid));
        enclosure.setLength((int)file.getLength());
        item.setEnclosure(enclosure);
        ItunesImageType itunesImage = new ItunesImageType();
        String href = id3.getAlbum().toUpperCase() + " 00" + id3.getTrack() + ".jpg";
        itunesImage.setHref("http://furfriction.com/podcast/episodes/" + encodeURI(href));
        item.setItunesImage(itunesImage);
        
        
        return item;
    }

    
    
    public static ID3v2 getID3v2(final Mp3File file) throws UnsupportedTagException{
        ID3v2 id3 = null;
        if (file.hasId3v2Tag()){
            id3 = file.getId3v2Tag();
        } else {
            throw new UnsupportedTagException(file.toString()+ " doesn't contain any ID3v2 tags");
        }
        
        return id3;
    }
    
    public static String encodeURI(String s) {
        String result;

        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }
    
    public static String getDuration(int duration) {
        
        String result = "";
        
        int h = (int)(duration/3600);
        result += h+":";
        int m = (int)(duration -(h*3600))/60;
        result += (m<10)?"0"+m+":":m+":";
        int s = (int)(duration -(h*3600)-(m*60));
        result += (s<10)?"0"+s:s;
        
        return result;
    }
    
    /**Example method for getting data from mp3file and logging it.
     * @param filename the filename to get data from, accepted parameter is {@link String}
     * @throws UnsupportedTagException declared later
     * @throws InvalidDataException declared later
     * @throws IOException declared later
     */
    public static void getExampleData(final String filename) throws UnsupportedTagException, InvalidDataException, IOException {
        Mp3File mp3File = new Mp3File(filename);
        logger.debug("Filename: " + mp3File.getFilename());
        logger.debug("Bitrate: " + mp3File.getBitrate());
        logger.debug("Samplerate: " + mp3File.getSampleRate());
        logger.debug("Channel Mode: " + mp3File.getChannelMode());

        if (mp3File.hasId3v1Tag()) {
            parseID3v1(mp3File);
        }
        if (mp3File.hasId3v2Tag()) {
            parseID3v2(mp3File);
        }
    }

    public static String parseArtist(final String filename) throws UnsupportedTagException, InvalidDataException, IOException {
        String artist = "";
        Mp3File mp3File = new Mp3File(filename);
        logger.debug("Trying to extract the Artist field from file: " + mp3File.getFilename());
        if (mp3File.hasId3v1Tag()) {
            ID3v1 id3v1 = mp3File.getId3v1Tag();
        }
        if (mp3File.hasId3v2Tag()) {
            ID3v2 id3v2 = mp3File.getId3v2Tag();
            artist = getArtist(id3v2);
            logger.debug("Artist field parsed: " + artist);
        }

        return artist;
    }

    private static String getArtist(final ID3v2 id3) {
        String artist = "";
        artist = id3.getArtist();
        return artist;
    }

    private static void parseID3v1(Mp3File mp3file) {
        logger.debug(mp3file.getFilename() + " has ID3v1 tag");
    }

    private static void parseID3v2(Mp3File mp3file) throws IOException {
        logger.debug(mp3file.getFilename() + " has ID3v2 tag");
        ID3v2 id3v2 = mp3file.getId3v2Tag();

        logger.debug(mp3file.getFilename() + " Artist: " + id3v2.getArtist());
        logger.debug(mp3file.getFilename() + " Title: " + id3v2.getTitle());
        logger.debug(mp3file.getFilename() + " Album: " + id3v2.getAlbum());
        logger.debug(mp3file.getFilename() + " Album Artist: " + id3v2.getAlbumArtist());
        logger.debug(mp3file.getFilename() + " Composer: " + id3v2.getComposer());
        logger.debug(mp3file.getFilename() + " Comment: " + id3v2.getComment());
        logger.debug(mp3file.getFilename() + " Itunes Comment: " + id3v2.getItunesComment());
        logger.debug(mp3file.getFilename() + " Copyright: " + id3v2.getCopyright());
        logger.debug(mp3file.getFilename() + " Data Length: " + id3v2.getDataLength());
        logger.debug(mp3file.getFilename() + " Encoder: " + id3v2.getEncoder());
        logger.debug(mp3file.getFilename() + " Genre: " + id3v2.getGenre());
        logger.debug(mp3file.getFilename() + " Genre Description: " + id3v2.getGenreDescription());
        logger.debug(mp3file.getFilename() + " Length: " + id3v2.getLength());
        logger.debug(mp3file.getFilename() + " Original Artist: " + id3v2.getOriginalArtist());
        logger.debug(mp3file.getFilename() + " Compilation: " + id3v2.getPartOfSet());
        logger.debug(mp3file.getFilename() + " Publisher: " + id3v2.getPublisher());
        logger.debug(mp3file.getFilename() + " Track Number: " + id3v2.getTrack());
        logger.debug(mp3file.getFilename() + " URL: " + id3v2.getUrl());
        logger.debug(mp3file.getFilename() + " Version: " + id3v2.getVersion());
        logger.debug(mp3file.getFilename() + " Year: " + id3v2.getYear());

        byte[] albumImageData = id3v2.getAlbumImage();
        if (albumImageData != null) {
            logger.debug(mp3file.getFilename() + "Album image data length: " + albumImageData.length + " bytes");
            logger.debug(mp3file.getFilename() + "Album image mime type: " + id3v2.getAlbumImageMimeType());

            String mimeType = id3v2.getAlbumImageMimeType();
            String albumImageFilename = parseDirectoryFromFilename(mp3file.getFilename()) + "/" + id3v2.getAlbum() + "."
                    + parseFileExtensionFromMimeType(mimeType);
            RandomAccessFile file = new RandomAccessFile(albumImageFilename, "rw");
            file.write(albumImageData);
            file.close();
            logger.debug("Album image from " + mp3file.getFilename() + " has written into file: " + albumImageFilename);
        }
    }

    private static String parseFileExtensionFromMimeType(String mimeType) {
        String extension = "unknown";
        int index = mimeType.indexOf('/');
        if (index > 0) {
            extension = mimeType.substring(index + 1).toLowerCase();
        } else {
            extension = mimeType.toLowerCase();
        }

        return extension;
    }

    private static String parseDirectoryFromFilename(String filename) {
        String directory = "";
        int index = filename.lastIndexOf("/");
        directory = filename.substring(0, index);
        return directory;
    }
}
