package pl.edu.agh.kis.pz1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WriterTest {
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
        assertTrue(writer1.isAlive());
        assertTrue(writer2.isAlive());
        assertTrue(writer3.isAlive());
        assertTrue(writer4.isAlive());
        assertTrue(writer5.isAlive());
        assertTrue(writer6.isAlive());
    }
}