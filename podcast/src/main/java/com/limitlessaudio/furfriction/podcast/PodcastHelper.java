package com.limitlessaudio.furfriction.podcast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.limitlessaudio.furfriction.podcast.file.FileParser;
import com.limitlessaudio.furfriction.podcast.xml.CharacterEscapeHandler;
import com.limitlessaudio.furfriction.podcast.xml.domain.ItemType;
import com.limitlessaudio.furfriction.podcast.xml.domain.RssType;

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
    public static void main(final String[] args) {

        logger.debug("Application Entry.");
        FileParser parser = new FileParser(new File(DIRECTORY));
        List<ItemType> newItems = parser.getItems(DIRECTORY);

        JAXBContext ctx;
        try {
            ctx = JAXBContext.newInstance(RssType.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            RssType rss = (RssType) unmarshaller.unmarshal(new File("resources/original.xml"));

            for (ItemType item : rss.getChannel().getItem()) {
                logger.debug(item.getAuthor() + " - " + item.getTitle());
            }

            ItemType item = parser.getParsedItemSkeleton(TEST_FILE);
            rss.getChannel().getItem().add(item);

            for (ItemType newitem : newItems) {
                rss.getChannel().getItem().add(newitem);
            }

            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler", new CharacterEscapeHandler());
            OutputStream outputXml = new FileOutputStream("resources/output.xml");
            BufferedWriter outputFormattedXml = new BufferedWriter(new FileWriter("resources/formatted-output.xml"));
            //            rss.getChannel().setLastBuildDate(DateConverter.convertDateToRFC2822(new Date()));
            marshaller.marshal(rss, outputXml);
            marshaller.marshal(rss, outputFormattedXml);
        } catch (JAXBException e) {
            logger.warn(e.toString());
        } catch (FileNotFoundException e) {
            logger.warn(e.toString());
        } catch (IOException e) {
            logger.warn(e.toString());
        }

    }
}
