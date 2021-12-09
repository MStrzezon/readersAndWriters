package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ReadingRoom {
    private int readers = 0;
    private int writers = 0;
    private static Logger logger = LogManager.getLogger(ReadingRoom.class);

    public void setReaders(int readers) {
        this.readers = readers;
    }

    public void setWriters(int writers) {
        this.writers = writers;
    }

    public int getReaders() {
        return readers;
    }

    public int getWriters() {
        return writers;
    }

    public synchronized void startWriting(){
        while (writers != 0 || readers != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        writers++;
    }

    public synchronized void endWriting() {
        writers--;
        notifyAll();
    }

    public synchronized void startReading() {
        while (writers != 0 || readers >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        readers++;
    }

    public synchronized void endReading() {
        readers--;
        notifyAll();
    }
}
