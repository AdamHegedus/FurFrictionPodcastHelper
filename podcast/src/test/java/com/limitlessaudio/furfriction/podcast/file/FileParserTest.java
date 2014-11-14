package com.limitlessaudio.furfriction.podcast.file;

import java.io.File;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**Test class for {@link FileParser} class.
 * @author adam_hegedus
 */
public class FileParserTest {

    FileParser underTest;

    @Before
    public void setUp() {

    }

    @Test(expected = RuntimeException.class)
    public void testParseDirectoryShouldThrowExceptionWhenGivenParameterIsNotDirectory() {
        // GIVEN
        File file = EasyMock.createMock(File.class);
        EasyMock.expect(file.isDirectory()).andReturn(false);
        EasyMock.expect(file.isFile()).andReturn(true);
        underTest = new FileParser(file);
        // WHEN
        underTest.parseDirectory();
        // THEN
        Assert.fail("Should throw RuntimeException!");
    }

    @Test(expected = RuntimeException.class)
    public void testParseDirectoryShouldThrowExceptionWhenGivenParameterIsNotExist() {
        // GIVEN
        File file = EasyMock.createMock(File.class);
        EasyMock.expect(file.isFile()).andReturn(false);
        EasyMock.expect(file.isDirectory()).andReturn(true);
        underTest = new FileParser(file);
        // WHEN
        underTest.parseDirectory();
        // THEN
        Assert.fail("Should throw RuntimeException!");
    }

}
