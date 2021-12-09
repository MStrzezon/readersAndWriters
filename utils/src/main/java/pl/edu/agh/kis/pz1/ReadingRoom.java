package pl.edu.agh.kis.pz1;

public class ReadingRoom {
    private int readers = 0;
    private int writers = 0;
    private String text;

    public synchronized void startWriting() {
        while (writers != 0 || readers != 0) {
            try {
                wait();
            } catch (InterruptedException ignored) { }
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
            } catch (InterruptedException ignored) { }
        }
        readers++;
    }

    public synchronized void endReading() {
        readers--;
        notifyAll();
    }
}
