package pl.edu.agh.kis.pz1;

import java.io.PipedOutputStream;

public class Writer extends Thread{
    private ReadingRoom readingRoom;
    String name;
    PipedOutputStream out;

    public Writer(ReadingRoom r, PipedOutputStream o, String n) {
        this.readingRoom =r;
        this.name = n;
        this.out = o;
    }

    public void run() {
        while (true) {
            try {
                readingRoom.startWriting();
                System.out.println(name + " is starting writing.");
                sleep((3000));
                System.out.println(name + " writes.");
                sleep((3000));
                readingRoom.endWriting();
                System.out.println(name + " is ending writing.");
                sleep(3000);
            } catch (InterruptedException ignored) {}
        }
    }
}
