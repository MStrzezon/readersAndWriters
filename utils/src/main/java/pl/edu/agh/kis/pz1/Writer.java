package pl.edu.agh.kis.pz1;

import java.io.PipedOutputStream;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Writer extends Thread{
    private ReadingRoom readingRoom;
    String name;
    PipedOutputStream out;
    private static Logger logger = LogManager.getLogger(Reader.class);

    public Writer(ReadingRoom r, PipedOutputStream o, String n) {
        this.readingRoom =r;
        this.name = n;
        this.out = o;
    }

    public void run() {
        while (true) {
            try {
                readingRoom.startWriting();
                logger.info(name + " is starting writing.");
                sleep((3000));
                logger.info(name + " writes.");
                sleep((3000));
                readingRoom.endWriting();
                logger.info(name + " is ending writing.");
                sleep(3000);
            } catch (InterruptedException ignored) {}
        }
    }
}
