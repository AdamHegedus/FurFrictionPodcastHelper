package com.limitlessaudio.furfriction.podcast;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.limitlessaudio.furfriction.podcast.util.MP3FileParser;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

/**The main application.
 * @author Adam_Hegedus
 *
 */
public final class PodcastHelper {

    private static Logger logger = LoggerFactory.getLogger(PodcastHelper.class);

    private PodcastHelper() {

    }

    /** The main entry point of the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        try {
            MP3FileParser.getExampleData("d:/data/EPC001.mp3");
        } catch (UnsupportedTagException e) {
            logger.warn(e.toString());
        } catch (InvalidDataException e) {
            logger.warn(e.toString());
        } catch (IOException e) {
            logger.warn(e.toString());
        }

        //
        //        JAXBContext ctx = JAXBContext.newInstance(Rss.class);
        //
        //        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        //        Marshaller marshaller = ctx.createMarshaller();
        //        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //
        //        Rss rss = (Rss) unmarshaller.unmarshal(new File("resources/original.xml"));
        //        Logger logger = Logger.getLogger("Rss.class");
        //        for (ItemType act : rss.getChannel().getItem()) {
        //            logger.log(Level.INFO, "Title: " + act.getTitle());
        //        }
        //
        //        OutputStream outputXml = new FileOutputStream("resources/output.xml");
        //
        //        marshaller.marshal(rss, outputXml);

    }
}
