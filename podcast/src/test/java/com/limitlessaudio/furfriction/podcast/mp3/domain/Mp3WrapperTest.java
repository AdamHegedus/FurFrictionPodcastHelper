package com.limitlessaudio.furfriction.podcast.mp3.domain;

import org.easymock.EasyMock;
import org.junit.Before;

import com.limitlessaudio.furfriction.podcast.mp3.adapter.Mp3Adapter;
import com.mpatric.mp3agic.Mp3File;

/**Test class for {@link Mp3Adapter} class.
 * @author adam_hegedus
 */
public class Mp3WrapperTest {

    private Mp3Adapter underTest;

    @Before
    public void setUp() {
        underTest = new Mp3Adapter();
        Mp3File file = EasyMock.createMock(Mp3File.class);
    }

}
