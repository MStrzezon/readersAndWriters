package pl.edu.agh.kis.pz1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PipedInputStream;

import static org.junit.Assert.*;

public class ReaderTest {
    private ReadingRoom readingRoom;
    private Reader reader;

    @Before
    public void setUp() throws Exception {
        readingRoom = new ReadingRoom();
        reader = new Reader(readingRoom, "Alex");
        reader.start();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void run() {
        assertTrue(reader.isAlive());
    }
}