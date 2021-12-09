package pl.edu.agh.kis.pz1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadingRoomTest {
    ReadingRoom readingRoom;

    @Before
    public void setUp() {
        readingRoom = new ReadingRoom();
    }

    @Test
    public void setReaders() {
        readingRoom.setReaders(2);
        assertEquals(2, readingRoom.getReaders());
        readingRoom.setReaders(1);
        assertEquals(1, readingRoom.getReaders());
    }

    @Test
    public void setWriters() {
        readingRoom.setWriters(3);
        assertEquals(3, readingRoom.getWriters());
        readingRoom.setWriters(1);
        assertEquals(1, readingRoom.getWriters());
    }

    @Test
    public void getReaders() {
        assertEquals(0, readingRoom.getReaders());
    }

    @Test
    public void getWriters() {
        assertEquals(0, readingRoom.getWriters());
    }

    @Test
    public void startWriting() {
    }

    @Test
    public void endWriting() {
    }

    @Test
    public void startReading() {
    }

    @Test
    public void endReading() {
    }
}