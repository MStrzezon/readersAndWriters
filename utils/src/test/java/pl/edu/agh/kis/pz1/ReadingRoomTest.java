package pl.edu.agh.kis.pz1;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Tests reading room class.
 */
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
    public void startEndWriting() throws InterruptedException {
        Writer writer1 = new Writer(readingRoom, "Jan");
        writer1.start();
        Writer writer2 = new Writer(readingRoom, "Adam");
        writer2.start();
        Writer writer3 = new Writer(readingRoom, "Marek");
        writer3.start();
        Writer writer4 = new Writer(readingRoom, "Zbigniew");
        writer4.start();
        Writer writer5 = new Writer(readingRoom, "Juliusz");
        writer5.start();
        Writer writer6 = new Writer(readingRoom, "Ignacy");
        writer6.start();
        for (int i = 0; i<1000; i++) {
            assertTrue((readingRoom.getWriters() <= 1) && readingRoom.getWriters() >= 0);
            TimeUnit.MILLISECONDS.sleep(4);
        }
    }

    @Test
    public void startEndReading() throws InterruptedException {
        Writer writer = new Writer(readingRoom, "Kochanowski");
        writer.start();
        Reader reader1 = new Reader(readingRoom, "Jan");
        reader1.start();
        Reader reader2 = new Reader(readingRoom, "Adam");
        reader2.start();
        Reader reader3 = new Reader(readingRoom, "Marek");
        reader3.start();
        Reader reader4 = new Reader(readingRoom, "Zbigniew");
        reader4.start();
        Reader reader5 = new Reader(readingRoom, "Juliusz");
        reader5.start();
        Reader reader6 = new Reader(readingRoom, "Ignacy");
        reader6.start();
        for (int i = 0; i<1000; i++) {
            assertTrue((readingRoom.getReaders() <= 5) && readingRoom.getReaders() >= 0);
            TimeUnit.MILLISECONDS.sleep(4);
        }
    }

}