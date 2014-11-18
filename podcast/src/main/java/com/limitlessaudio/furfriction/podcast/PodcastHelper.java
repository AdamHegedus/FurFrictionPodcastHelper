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

import com.limitlessaudio.furfriction.podcast.file.FileParser;
import com.limitlessaudio.furfriction.podcast.util.DateConverter;
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
    private static final String TEST_FILE = "d:/data/EPC001.mp3";
    //    private static final String TEST_DIRECTORY = "d:/data/test/1";
    //    private static final String TEST_FILE = "d:/FUR FRICTION Podcast/FUR FRICTION 006 DSH - Big Fat Cat.mp3";
    private static final String DIRECTORY = "d:/test/";

    private PodcastHelper() {

    }

    /** The main entry point of the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        logger.debug("Application Entry.");
        FileParser parser = new FileParser(new File(DIRECTORY));
        //        parser.parseDirectory();

        JAXBContext ctx;
        try {
            ctx = JAXBContext.newInstance(Rss.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Rss rss = (Rss) unmarshaller.unmarshal(new File("resources/original.xml"));

            for (ItemType item : rss.getChannel().getItem()) {
                logger.debug(item.getAuthor() + " - " + item.getTitle());
            }

            try {
                ItemType item = parser.getParsedItemSkeleton(TEST_FILE);
                rss.getChannel().getItem().add(item);

            } catch (UnsupportedTagException | InvalidDataException | IOException e) {
                logger.warn(e.toString());
            }

            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream outputXml = new FileOutputStream("resources/output.xml");
            rss.getChannel().setLastBuildDate(DateConverter.convertDateToRFC2822(new Date()));
            marshaller.marshal(rss, outputXml);
        } catch (JAXBException e) {
            logger.warn(e.toString());
        } catch (FileNotFoundException e) {
            logger.warn(e.toString());
        }

    }
}
