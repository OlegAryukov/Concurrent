package ru.aryukov.romanchick.example.audiochannel;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChannelPool<T> {
    private final static int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Lock lockChannels;

    private final LinkedList<AudioChannel> resources = new LinkedList<AudioChannel>();

    public ChannelPool(LinkedList<AudioChannel> sources) {
        resources.addAll(sources);
        lockChannels = new ReentrantLock();
    }

    public AudioChannel getResource(long waitMaxMills) throws ResourceException {
        try {
            if (semaphore.tryAcquire(waitMaxMills, TimeUnit.MILLISECONDS)) {
                AudioChannel res = getChannel();
                return res;
            }
        } catch (InterruptedException e) {
            throw new ResourceException(e);
        }
        throw new ResourceException(":wait to long!");
    }

    public void returnResource(AudioChannel res) {
        res.setNowUsing(false);
        semaphore.release();
    }

    private AudioChannel getChannel() {
        AudioChannel ret = null;
        try {
            lockChannels.lock();
            for (AudioChannel channel : resources) {
                if (!channel.isNowUsing()){
                    ret = channel;
                    channel.setNowUsing(true);
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lockChannels.unlock();
        }
        return ret;
    }
}

