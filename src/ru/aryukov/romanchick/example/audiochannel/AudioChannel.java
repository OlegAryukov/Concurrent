package ru.aryukov.romanchick.example.audiochannel;

import java.util.Random;

public class AudioChannel {
    private int channelId;
    private boolean nowUsing;

    public AudioChannel(int channelId) {
        this.channelId = channelId;
        nowUsing = false;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public boolean isNowUsing() {
        return nowUsing;
    }

    public void setNowUsing(boolean nowUsing) {
        this.nowUsing = nowUsing;
    }

    public void using(){
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
