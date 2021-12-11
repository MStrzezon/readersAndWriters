package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Reader extends Thread{
    private ReadingRoom readingRoom;
    private String name;
    String textRead;
    String newText;
    int numberOfReadBooks;
    private static Logger logger = LogManager.getLogger(Reader.class);

    public Reader(ReadingRoom r, String n) {
        this.readingRoom = r;
        this.name = n;
        this.textRead = "";
        this.newText = "";
        this.numberOfReadBooks = 0;
    }

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
