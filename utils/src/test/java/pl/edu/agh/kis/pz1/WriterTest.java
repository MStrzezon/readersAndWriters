package pl.edu.agh.kis.pz1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WriterTest {
    private ReadingRoom readingRoom;
    private Writer writer;

    @Before
    public void setUp() throws Exception {
        readingRoom = new ReadingRoom();
        writer = new Writer(readingRoom, "Jan");
        writer.start();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void run() {
        assertTrue(writer.isAlive());
    }
}