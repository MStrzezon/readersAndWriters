package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class ReadingRoom {
    private int readers = 0;
    private int writers = 0;
    private String text = "";
    int books = 0;
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
        books++;
        writers--;
        notifyAll();
    }

    public synchronized void startReading(int numberOfReadBooks) {
        while (writers != 0 || readers >= 5 || numberOfReadBooks == books) {
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
