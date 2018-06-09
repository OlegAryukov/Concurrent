package ru.aryukov.romanchick.example.cyclicbarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;
    public final int BID = 5;

    public Auction() {
        this.bids = new ArrayList<Bid>();
        this.barrier = new CyclicBarrier(this.BID, () -> {
            Bid winner = Auction.this.defineWinner();
            System.out.println("Bid #" + winner.getBidId() + ",  price:" + winner.getPrice() + " win!");
        });
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public boolean addBid(Bid bid){
        return bids.add(bid);
    }

    public Bid defineWinner(){
        return Collections.max(bids, new Comparator<Bid>(){
            @Override
            public int compare(Bid o1, Bid o2){
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
}
