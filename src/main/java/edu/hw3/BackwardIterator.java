package edu.hw3;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {

    private final List<T> list;
    private int index;

    public BackwardIterator(List<T> list) {
        this.list = list;
        this.index = list.size();
    }

    @Override
    public boolean hasNext() {
        return index - 1 >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new ArrayIndexOutOfBoundsException("За пределеами");
        } else {
            return list.get(--index);
        }
    }
}
