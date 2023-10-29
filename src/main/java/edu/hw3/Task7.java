package edu.hw3;

import java.util.Comparator;

public class Task7<T extends Comparable<T>> implements Comparator<T> {

    public Task7() {

    }

    @Override
    public int compare(T o1, T o2) {
        if (o1 == o2) {
            return 0;
        } else if (o1 == null || o2 == null) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}
