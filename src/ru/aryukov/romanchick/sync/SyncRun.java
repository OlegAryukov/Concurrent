package ru.aryukov.romanchick.sync;

import java.io.IOException;

public class SyncRun {
    public static void main(String[] args) {
        Resource s = null;

        try {
            s = new Resource("result.txt");
            SyncThread t1 = new SyncThread("First ", s);
            SyncThread t2 = new SyncThread("Second ", s);

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
