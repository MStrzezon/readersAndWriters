package pl.edu.agh.kis.pz1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PipedInputStream;

import static org.junit.Assert.*;

/**
 * Tests reader class.
 */
public class ReaderTest {
    private ReadingRoom readingRoom;

    @Before
    public void setUp() throws Exception {
        readingRoom = new ReadingRoom();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void run() {
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
        assertTrue(reader1.isAlive());
        assertTrue(reader2.isAlive());
        assertTrue(reader3.isAlive());
        assertTrue(reader4.isAlive());
        assertTrue(reader5.isAlive());
        assertTrue(reader6.isAlive());
    }
}