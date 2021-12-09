package pl.edu.agh.kis.pz1;

import java.io.PipedInputStream;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Reader extends Thread{
    private ReadingRoom readingRoom;
    private String name;
    PipedInputStream in;
    private static Logger logger = LogManager.getLogger(Reader.class);

    public Reader(ReadingRoom r, PipedInputStream i, String n) {
        this.readingRoom = r;
        this.name = n;
        this.in = i;
    }

    @Override
    public void run() {
        while (true) {
            try {
                readingRoom.startReading();
                logger.info(name + " starts reading.");
                sleep((int)(3000));
                logger.info(name + " are reading.");
                sleep((int)(3000));
                logger.info(name + " is ending reading");
                readingRoom.endReading();
                sleep((int)(3000));
            } catch (InterruptedException ignored) {}
        }
    }
}
