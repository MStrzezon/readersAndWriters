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
    public static void main(String[] args) {
        ReadingRoom readingRoom = new ReadingRoom();
        new Writer(readingRoom, "Jan Kochanowski").start();
        new Writer(readingRoom, "Adam Mickiewicz").start();
        new Writer(readingRoom, "Juliusz Slowacki").start();
        new Reader(readingRoom, "Adam").start();
        new Reader(readingRoom, "Krzysiek").start();
        new Reader(readingRoom, "Michal").start();
        new Reader(readingRoom, "Wojtek").start();
        new Reader(readingRoom, "Julek").start();
        new Reader(readingRoom, "Marcin").start();
        new Reader(readingRoom, "Zygfryt").start();
        new Reader(readingRoom, "Kacper").start();
        new Reader(readingRoom, "Karolina").start();
        new Reader(readingRoom, "Martyna").start();
    }
}
