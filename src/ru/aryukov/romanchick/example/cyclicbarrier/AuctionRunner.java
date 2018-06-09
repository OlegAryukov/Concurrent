package ru.aryukov.romanchick.example.cyclicbarrier;

import java.util.Random;

public class AuctionRunner {
    public static void main(String[] args) {
        Auction auction = new Auction();
        int startPrice = new Random().nextInt(100);
        for (int i = 0; i < auction.BID; i++){
            Bid thread = new Bid(i, startPrice, auction.getBarrier());
            auction.addBid(thread);
            thread.start();
        }
    }
}
