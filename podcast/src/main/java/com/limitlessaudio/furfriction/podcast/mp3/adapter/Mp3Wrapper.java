package com.limitlessaudio.furfriction.podcast.mp3.adapter;

import java.io.IOException;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

public class Mp3Wrapper {
    private Mp3File file;

    /**
     * @param file
     */
    public Mp3Wrapper(final String filename) {
        super();
        try {
            this.file = new Mp3File(filename);
        } catch (UnsupportedTagException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidDataException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
