package pl.edu.agh.kis.pz1;

import java.io.PipedOutputStream;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Writer extends Thread{
    private ReadingRoom readingRoom;
    String name;
    PipedOutputStream out;
    private static Logger logger = LogManager.getLogger(Writer.class);

    public Writer(ReadingRoom r, PipedOutputStream o, String n) {
        this.readingRoom =r;
        this.name = n;
        this.out = o;
    }

    @Override
    public void run() {
        while (true) {
            try {
                readingRoom.startWriting();
                logger.info( "{} is starting writing.", name);
                sleep((3000));
                logger.info("{} writes.", name);
                sleep((3000));
                readingRoom.endWriting();
                logger.info("{} is ending writing.", name);
                sleep(3000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
