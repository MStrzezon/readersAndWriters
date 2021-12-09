package pl.edu.agh.kis.pz1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main(String[] args) throws IOException {
        ReadingRoom readingRoom = new ReadingRoom();
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);
        new Writer(readingRoom, out, "Jan Kochanowski").start();
        new Writer(readingRoom, out, "Adam Mickiewicz").start();
        new Writer(readingRoom, out, "Juliusz Slowacki").start();
        new Reader(readingRoom, in, "Adam").start();
        new Reader(readingRoom, in, "Krzysiek").start();
        new Reader(readingRoom, in, "Michal").start();
        new Reader(readingRoom, in, "Wojtek").start();
        new Reader(readingRoom, in, "Julek").start();
        new Reader(readingRoom, in, "Marcin").start();
        new Reader(readingRoom, in, "Zygfryt").start();
        new Reader(readingRoom, in, "Kacper").start();
        new Reader(readingRoom, in, "Karolina").start();
        new Reader(readingRoom, in, "Martyna").start();
    }
}
