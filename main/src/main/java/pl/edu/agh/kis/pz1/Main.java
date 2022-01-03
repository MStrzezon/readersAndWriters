package pl.edu.agh.kis.pz1;


/**
 * Main class!
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException {
        ReadingRoom readingRoom = new ReadingRoom();
        new Writer(readingRoom, "Jan Kochanowski").start();
        Thread.sleep(10);
        new Writer(readingRoom, "Adam Mickiewicz").start();
        Thread.sleep(10);
        new Writer(readingRoom, "Juliusz Slowacki").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Adam").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Krzysiek").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Michal").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Wojtek").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Julek").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Marcin").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Zygfryt").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Kacper").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Karolina").start();
        Thread.sleep(10);
        new Reader(readingRoom, "Martyna").start();
    }
}
