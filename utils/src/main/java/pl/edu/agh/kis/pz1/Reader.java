package pl.edu.agh.kis.pz1;

import java.io.IOException;
import java.io.PipedInputStream;

public class Reader extends Thread{
    private ReadingRoom readingRoom;
    private String name;
    PipedInputStream in;

    public Reader(ReadingRoom r, PipedInputStream i, String n) {
        this.readingRoom = r;
        this.name = n;
        this.in = i;
    }

    public void run() {
        while (true) {
            try {
                readingRoom.startReading();
                System.out.println(name + " starts reading.");
                sleep((int)(3000));
                System.out.println(name + " are reading.");
                sleep((int)(3000));
                System.out.println(name + " is ending reading");
                readingRoom.endReading();
                sleep((int)(3000));
            } catch (InterruptedException ignored) {}
        }
    }
}
