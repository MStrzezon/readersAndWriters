package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class representing the reader.
 * The reader object encapsulates name and wants to enter to the reading room
 * to read books.
 *
 * @author Michał Strzeżoń
 */
public class Reader extends Thread{
    /**
     * the reading room the reader enters.
     */
    private final ReadingRoom readingRoom;
    /**
     * name of the reader.
     */
    private final String name;
    /**
     * number of read books by the reader.
     */
    int numberOfReadBooks;
    private static final Logger logger = LogManager.getLogger(Reader.class);

    /**
     * Creates the reader object.
     * @param r reading room the reader will be enter.
     * @param n name of the reader.
     */
    public Reader(ReadingRoom r, String n) {
        this.readingRoom = r;
        this.name = n;
        this.numberOfReadBooks = 0;
    }

    /**
     * Starts the thread.
     * Reader:
     * <ul>
     *     <li>wants to enter to the reading room,</li>
     *     <li>is reading the book,</li>
     *     <li>is ending reading.</li>
     * </ul>
     */
    @Override
    public void run() {
        while (true) {
            try {
                logger.info("Reader {} wants enter.", name);
                readingRoom.startReading(numberOfReadBooks);
                sleep((1000));
                logger.info("{} are reading book nr. {}", name, numberOfReadBooks);
                numberOfReadBooks++;
                sleep((1000));
                logger.info("{} is ending reading", name);
                readingRoom.endReading();
                sleep((1000));
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
