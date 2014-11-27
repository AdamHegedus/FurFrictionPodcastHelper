package com.limitlessaudio.furfriction.podcast.xml;

import java.io.IOException;
import java.io.Writer;

/**Character escape handler implementation.
 * @author adam_hegedus
 */
public class CharacterEscapeHandler implements com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler {

    @Override
    public void escape(char[] characters, int start, int length, boolean isAttVal, Writer writer) throws IOException {
        writer.write(characters, start, length);
    }

}
