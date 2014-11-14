package com.limitlessaudio.furfriction.podcast;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.limitlessaudio.furfriction.podcast.file.FileParser;

/**The main application.
 * @author Adam_Hegedus
 *
 */
public final class PodcastHelper {

    private static Logger logger = LoggerFactory.getLogger(PodcastHelper.class);
    private static final String TEST_FILE = "d:/data/EPC001.mp3";
    private static final String TEST_DIRECTORY = "d:/data/test/1";

    //    private static final String TEST_FILE = "d:/FUR FRICTION Podcast/FUR FRICTION 006 DSH - Big Fat Cat.mp3";

    private PodcastHelper() {

    }

    /** The main entry point of the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        FileParser parser = new FileParser(new File(TEST_DIRECTORY));
        parser.parseDirectory();

        //        JAXBContext ctx;
        //        try {
        //            ctx = JAXBContext.newInstance(Rss.class);
        //            Unmarshaller unmarshaller = ctx.createUnmarshaller();
        //            Rss rss = (Rss) unmarshaller.unmarshal(new File("resources/original.xml"));
        //
        //            for (ItemType item : rss.getChannel().getItem()) {
        //                logger.debug(item.getAuthor() + " - " + item.getTitle());
        //            }
        //
        //            ItemType newItem = new ItemType();
        //
        //            try {
        //                newItem = MP3FileParser.getItemSkeletonFromAudioFile(TEST_FILE);
        //                rss.getChannel().getItem().add(newItem);
        //            } catch (UnsupportedTagException e) {
        //                logger.warn(e.toString());
        //            } catch (InvalidDataException e) {
        //                logger.warn(e.toString());
        //            } catch (IOException e) {
        //                logger.warn(e.toString());
        //            }
        //
        //            Marshaller marshaller = ctx.createMarshaller();
        //            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //            OutputStream outputXml = new FileOutputStream("resources/output.xml");
        //            rss.getChannel().setLastBuildDate(DateConverter.convertDateToRFC2822(new Date()));
        //            marshaller.marshal(rss, outputXml);
        //        } catch (JAXBException e) {
        //            logger.warn(e.toString());
        //        } catch (FileNotFoundException e) {
        //            logger.warn(e.toString());
        //        }

    }
}
