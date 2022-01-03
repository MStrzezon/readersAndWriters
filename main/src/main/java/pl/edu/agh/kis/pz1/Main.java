package pl.edu.agh.kis.pz1;

import java.util.Arrays;
import java.util.List;

/**
 * Main class!
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException {
        ReadingRoom readingRoom = new ReadingRoom();
        List<String> writersNames = Arrays.asList("Jan Kochanowski", "Adam Mickiewicz", "Juliusz Slowacki");
        List<String> readersNames = Arrays.asList("Adam", "Krzysiek", "Michal", "Wojtek", "Julek", "Marcin", "Zygfryt",
                                                    "Kacper", "Karolina", "Martyna");
        for (String name : writersNames) {
            new Writer(readingRoom, name).start();
            Thread.sleep(10);
        }
        for (String name : readersNames) {
            new Reader(readingRoom, name).start();
            Thread.sleep(10);
        }
    }
}
