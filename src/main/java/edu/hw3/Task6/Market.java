package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Market implements StockMarket {
    private final Queue<Stock> stocks;
    private final String message = "Null Stock";

    public Market() {
        stocks = new PriorityQueue<>(new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return -Integer.compare(o1.value(), o2.value());
            }
        });
    }

    @Override
    public void add(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException(message);
        }
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException(message);
        }
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
