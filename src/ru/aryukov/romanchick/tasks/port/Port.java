package ru.aryukov.romanchick.tasks.port;

import java.util.concurrent.atomic.AtomicLong;

public class Port {
    private AtomicLong counOfContainers;

    public AtomicLong getCounOfContainers() {
        return counOfContainers;
    }

    public void setCounOfContainers(AtomicLong counOfContainers) {
        this.counOfContainers = counOfContainers;
    }
}
