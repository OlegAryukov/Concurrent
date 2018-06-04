package ru.aryukov.romanchick.example;

import ru.aryukov.Main;

import java.util.concurrent.atomic.AtomicLong;

public class MarketDemo {
    private static final int NUM_BROKERS = 30;
    public static void main(String[] args) {
        Market market = new Market(new AtomicLong(100));
        market.start();
        for (int i = 0; i < NUM_BROKERS; i++){
            new Broker(market).start();
        }
    }
}
