package edu.hw3.Task5;

import java.util.Comparator;

public class ComparatorAsc implements Comparator<Contact> {
    @Override
    public int compare(Contact first, Contact second) {
        String compare1;
        String compare2;

        if (!first.surname().isEmpty()) {
            compare1 = first.surname();
        } else {
            compare1 = first.name();
        }

        if (!second.surname().isEmpty()) {
            compare2 = second.surname();
        } else {
            compare2 = second.name();
        }
        return compare1.compareTo(compare2);
    }
}
