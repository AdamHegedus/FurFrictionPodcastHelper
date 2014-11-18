package com.limitlessaudio.furfriction.podcast.mp3.domain;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**Test class for {@link Id3v2Data} class.
 * @author x
 */
public class Id3v2DataTest {

    private Id3v2Data underTest;

    @Before
    public void setUp() {
        underTest = new Id3v2Data();
    }

    @Test
    public void testGetTrackNumberFormattedToThreeCharacter() {
        // GIVEN
        final String expected = "005";
        underTest.setTrackNumber("5");
        // WHEN
        String actual = underTest.getTrackNumberFormattedToThreeCharacter();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTrackNumberFormattedToThreeCharacterShouldReturnThreeZeroesWhenTheTrackNumberIsNotSet() {
        // GIVEN
        final String expected = "000";
        // WHEN
        String actual = underTest.getTrackNumberFormattedToThreeCharacter();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTrackNumberFormattedToThreeCharacterShouldReturnZeroTwelveWhenTheTrackNumberIsSetToTwelve() {
        // GIVEN
        final String expected = "012";
        underTest.setTrackNumber("12");
        // WHEN
        String actual = underTest.getTrackNumberFormattedToThreeCharacter();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTrackNumberFormattedToThreeCharacterShouldReturnOneTwoThreeWhenTheTrackNumberIsSetToOneTwoThree() {
        // GIVEN
        final String expected = "123";
        underTest.setTrackNumber("123");
        // WHEN
        String actual = underTest.getTrackNumberFormattedToThreeCharacter();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDurationFormattedWhenGivenOneHour() {
        // GIVEN
        final String expected = "1:00:00";
        underTest.setDuration(3600);
        // WHEN
        String actual = underTest.getDurationFormatted();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDurationFormattedWhenGivenOneHourOneMinute() {
        // GIVEN
        final String expected = "1:01:00";
        underTest.setDuration(3660);
        // WHEN
        String actual = underTest.getDurationFormatted();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDurationFormattedWhenGivenOneHourOneMinuteOneSecond() {
        // GIVEN
        final String expected = "1:01:01";
        underTest.setDuration(3661);
        // WHEN
        String actual = underTest.getDurationFormatted();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDurationFormattedWhenGivenOneHourTwelveMinuteTwelveSecond() {
        // GIVEN
        final String expected = "1:12:12";
        underTest.setDuration(4332);
        // WHEN
        String actual = underTest.getDurationFormatted();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDurationFormattedWhenGivenLessThanOneHour() {
        // GIVEN
        final String expected = "12:12";
        underTest.setDuration(732);
        // WHEN
        String actual = underTest.getDurationFormatted();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDurationFormattedWhenGivenLessThanOneMinute() {
        // GIVEN
        final String expected = "12";
        underTest.setDuration(12);
        // WHEN
        String actual = underTest.getDurationFormatted();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCommentAsCData() {
        // GIVEN
        final String expected = "<![CDATA[Comments inside the CDATA element.]]>";
        underTest.setComment("Comments inside the CDATA element.");
        // WHEN
        String actual = underTest.getCommentAsCData();
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetItunesSubtitle() {
        // GIVEN
        final String expected = "FUR FRICTION 007";
        underTest.setAlbum("Fur Friction");
        underTest.setTrackNumber("7");
        // WHEN
        String actual = underTest.getItunesSubtitle();
        // THEN
        Assert.assertEquals(expected, actual);
    }

}
