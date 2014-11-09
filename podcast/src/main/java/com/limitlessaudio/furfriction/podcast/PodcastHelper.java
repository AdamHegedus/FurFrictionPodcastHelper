package com.limitlessaudio.furfriction.podcast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.limitlessaudio.furfriction.podcast.util.DateConverter;
import com.limitlessaudio.furfriction.podcast.util.MP3FileParser;
import com.limitlessaudio.furfriction.podcast.xml.ItemType;
import com.limitlessaudio.furfriction.podcast.xml.Rss;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

/**The main application.
 * @author Adam_Hegedus
 *
 */
public final class PodcastHelper {

    private static Logger logger = LoggerFactory.getLogger(PodcastHelper.class);
    //private final static String TEST_FILE = "d:/data/EPC001.mp3";
    private final static String TEST_FILE = "d:/FUR FRICTION Podcast/FUR FRICTION 006 DSH - Big Fat Cat.mp3";

    private PodcastHelper() {

    }

    /** The main entry point of the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        //        try {
        //            MP3FileParser.getExampleData(TEST_FILE);
        //        } catch (UnsupportedTagException e) {
        //            logger.warn(e.toString());
        //        } catch (InvalidDataException e) {
        //            logger.warn(e.toString());
        //        } catch (IOException e) {
        //            logger.warn(e.toString());
        //        }

        JAXBContext ctx;
        try {
            ctx = JAXBContext.newInstance(Rss.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Rss rss = (Rss) unmarshaller.unmarshal(new File("resources/original.xml"));

            for (ItemType item : rss.getChannel().getItem()) {
                logger.debug(item.getAuthor() + " - " + item.getTitle());
            }

            /*
             * <title>Big Fat Cat</title>
             * <link>http://furfriction.com/podcast/episodes/FUR%20FRICTION%20006%20DSH%20-%20Big%20Fat%20Cat.mp3</link>
             * <description></description>
             * <guid>http://furfriction.com/podcast/episodes/FUR%20FRICTION%20006%20DSH%20-%20Big%20Fat%20Cat.mp3</guid>
             * <enclosure url="http://furfriction.com/podcast/episodes/FUR%20FRICTION%20006%20DSH%20-%20Big%20Fat%20Cat.mp3" length="0" type="audio/mpeg"/>
             * <pubDate>Sun, 26 Oct 2014 20:00:00 +0100</pubDate>
             * <author>DSH</author>
             * <itunes:author>DSH</itunes:author>
             * <itunes:subtitle>FUR FRICTION 006</itunes:subtitle>
             * <itunes:summary></itunes:summary>
             * <itunes:duration>0</itunes:duration>
             * <itunes:image href="http://furfriction.com/podcast/episodes/FUR%20FRICTION%20006.jpg"/>
             * <itunes:explicit>Clean</itunes:explicit>
             */
            ItemType newItem = new ItemType();
            
            String author;
            try {
                  newItem = MP3FileParser.getItemSkeletonFromAudioFile(TEST_FILE);
//                author = MP3FileParser.parseArtist(TEST_FILE);
//                newItem.setAuthor(author);
//                newItem.setItunesAuthor(author);
//                newItem.setItunesExplicit("clean");
//                newItem.setPubDate(DateConverter.convertDateToRFC2822(new Date()));

                rss.getChannel().getItem().add(newItem);
            } catch (UnsupportedTagException e) {
                logger.warn(e.toString());
            } catch (InvalidDataException e) {
                logger.warn(e.toString());
            } catch (IOException e) {
                logger.warn(e.toString());
            }

            /*
             */

            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream outputXml = new FileOutputStream("resources/output.xml");
            rss.getChannel().setLastBuildDate(DateConverter.convertDateToRFC2822(new Date()));
            marshaller.marshal(rss, outputXml);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            logger.warn(e.toString());
        } catch (FileNotFoundException e) {
            logger.warn(e.toString());
        }

    }
}
