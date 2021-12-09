package pl.edu.agh.kis.pz1;

import java.io.PipedInputStream;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Reader extends Thread{
    private ReadingRoom readingRoom;
    private String name;
    private static Logger logger = LogManager.getLogger(Reader.class);

    public Reader(ReadingRoom r, String n) {
        this.readingRoom = r;
        this.name = n;
    }

    @Override
    public void run() {
        while (true) {
            try {
                readingRoom.startReading();
                logger.info("{} starts reading.", name);
                sleep((3000));
                logger.info("{} are reading.", name);
                sleep((3000));
                logger.info("{} is ending reading", name);
                readingRoom.endReading();
                sleep((3000));
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
