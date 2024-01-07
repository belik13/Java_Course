package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
