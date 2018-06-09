package ru.aryukov.romanchick.example.audiochannel;

public class Client extends Thread {
    private ChannelPool<AudioChannel> pool;
    private AudioChannel channel;

    public Client(ChannelPool<AudioChannel> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            channel = pool.getResource(5000);
            System.out.println("Channel Client #" + this.getId() + " took channel #" + channel.getChannelId());
            channel.using();
        } catch (ResourceException e) {
            System.out.println("Client #" + this.getId() + " lost ->" + e.getMessage());
        } finally {
            if (channel != null) {
                System.out.println("Channel Client #" + this.getId() + " : " + channel.getChannelId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }

}
