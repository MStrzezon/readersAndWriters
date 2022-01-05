package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class extending Thread, representing the writer.
 * The writer object encapsulates name and wants to enter to the reading room
 * to write books.
 *
 * @author Michał Strzeżoń
 */
public class Writer extends Thread{
    /**
     * the reading room the writer enters.
     */
    private ReadingRoom readingRoom;
    /**
     * name of the writer.
     */
    String name;
    private static Logger logger = LogManager.getLogger(Writer.class);

    /**
     * Creates the writer object.
     * @param r reading room the writer will enter.
     * @param n name of the writer
     */
    public Writer(ReadingRoom r, String n) {
        this.readingRoom =r;
        this.name = n;
    }

    /**
     * Starts the thread.
     * Writer:
     * <ul>
     *     <li>wants to enter to the reading room,</li>
     *     <li>is writing the book</li>
     *     <li>is ending writing</li>
     * </ul>
     */
    @Override
    public void run() {

        while (true) {
            try {
                logger.info( "Writer {} wants enter.", name);
                readingRoom.startWriting();
                logger.info("{} writes.", name);
                sleep((2000));
                logger.info("{} is ending writing.", name);
                readingRoom.endWriting();
                sleep(2000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
