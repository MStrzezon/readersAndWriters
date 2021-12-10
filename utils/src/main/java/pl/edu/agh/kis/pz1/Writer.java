package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Writer extends Thread{
    private ReadingRoom readingRoom;
    String name;
    private static Logger logger = LogManager.getLogger(Writer.class);

    public Writer(ReadingRoom r, String n) {
        this.readingRoom =r;
        this.name = n;
    }

    @Override
    public void run() {
        while (true) {
            try {
                logger.info( "Writer {} wants enter.", name);
                readingRoom.startWriting();
                sleep((3000));
                logger.info("{} writes.", name);
                sleep((3000));
                logger.info("{} is ending writing.", name);
                readingRoom.endWriting();
                sleep(3000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
