package ru.aryukov.romanchick.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Market extends Thread {
    private AtomicLong index;

    public Market(AtomicLong index){
        this.index = index;
    }

    public AtomicLong getIndex() {
        return index;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true){
                index.getAndAdd(random.nextInt(10));
                Thread.sleep(random.nextInt(500));
                index.getAndAdd(-1 * random.nextInt(10));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
