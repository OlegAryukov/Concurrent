package ru.aryukov.romanchick.sync;

public class SyncThread extends Thread {
    private Resource resource;

    public SyncThread(String name, Resource res) {
        super(name);
        this.resource = res;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.writing(getName(), i);
        }
    }
}

