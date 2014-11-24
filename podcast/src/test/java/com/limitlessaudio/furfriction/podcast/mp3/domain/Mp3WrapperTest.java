package com.limitlessaudio.furfriction.podcast.mp3.domain;

import org.easymock.EasyMock;
import org.junit.Before;

import com.limitlessaudio.furfriction.podcast.mp3.wrapper.Mp3Wrapper;
import com.mpatric.mp3agic.Mp3File;

/**Test class for {@link Mp3Wrapper} class.
 * @author adam_hegedus
 */
public class Mp3WrapperTest {

    private Mp3Wrapper underTest;

    @Before
    public void setUp() {
        underTest = new Mp3Wrapper();
        Mp3File file = EasyMock.createMock(Mp3File.class);
    }

}
