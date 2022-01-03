package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Class representing the reading room.
 * The reading room encapsulates:
 * <ul>
 *     <li>number of readers in the reading room,</li>
 *     <li>number of writer in the reading room,</li>
 *     <li>number of waiting readers in the reading room,</li>
 *     <li>number of waiting writers in the reading room,</li>
 *     <li>books in the reading room</li>
 * </ul>
 */
public class ReadingRoom {
    /**
     * number of readers.
     */
    private int readers = 0;
    /**
     * number of writers.
     */
    private int writers = 0;
    /**
     * number of waiting readers.
     */
    private int waitingReaders = 0;
    /**
     * number of waiting writers.
     */
    private int waitingWriters = 0;
    /**
     * number of books.
     */
    int books = 0;
    private static final Logger logger = LogManager.getLogger(ReadingRoom.class);

    /**
     * Sets number of readers in the reading room.
     * @param readers new number of readers.
     */
    public void setReaders(int readers) {
        this.readers = readers;
    }

    /**
     * Sets number of writers in the reading room.
     * @param writers new number of writers.
     */
    public void setWriters(int writers) {
        this.writers = writers;
    }

    /**
     * Gets number of readers in the reading room.
     * @return number of readers.
     */
    public int getReaders() {
        return readers;
    }

    /**
     * Gets number of writers in the reading room.
     * @return number of writers.
     */
    public int getWriters() {
        return writers;
    }

    /**
     * Sets number of waiting readers.
     * @param readers new number of waiting readers.
     */
    public void setWaitingReaders(int readers) {
        this.readers = readers;
    }

    /**
     * Sets number of waiting writers in the reading room.
     * @param writers new number of waiting writers.
     */
    public void setWaitingWriters(int writers) {
        this.writers = writers;
    }

    /**
     * Gets number of waiting readers.
     * @return number of waiting readers.
     */
    public int getWaitingReaders() {
        return readers;
    }

    /**
     * Gets number of waiting writers.
     * @return number of waiting writers.
     */
    public int getWaitingWriters() {
        return writers;
    }

    /**
     * Makes that writers enters to the reading room or makes him wait for his turn.
     * The writer can enter where there is any other writer or reader.
     * Informs also about number of writers/readers in reading room and waiting writers/readers.
     * It is synchronized method.
     */
    public synchronized void startWriting(){
        logger.info("Writers in reading room: {}\nReaders in reading room: {}",writers, readers);
        waitingWriters++;
        logger.info("Waiting writers: {}\nWaiting readers: {}", waitingWriters, waitingReaders);
        while (writers != 0 || readers != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        waitingWriters--;
        writers++;
    }

    /**
     * Makes that writer ends writing and goes out.
     * It is synchronized method.
     */
    public synchronized void endWriting() {
        books++;
        writers--;
        notifyAll();
    }

    /**
     * Makes that readers starts reading or makes him wait for his turn.
     * The reader can enter where there is any writer or number of reader is less than 5.
     * Informs also about number of writers/readers in reading room and waiting writers/readers.
     * It is synchronized method.
     * @param numberOfReadBooks number of read books by this reader.
     */
    public synchronized void startReading(int numberOfReadBooks) {
        logger.info("Writers in reading room: {}\nReaders in reading room: {}",writers, readers);
        waitingReaders++;
        logger.info("Waiting writers: {}\nWaiting readers: {}", waitingWriters, waitingReaders);
        while (writers != 0 || readers >= 5 || numberOfReadBooks == books) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        waitingReaders--;
        readers++;
    }

    /**
     * Makes that readers end reading and goes out.
     * It is synchronized method.
     */
    public synchronized void endReading() {
        readers--;
        notifyAll();
    }
}
