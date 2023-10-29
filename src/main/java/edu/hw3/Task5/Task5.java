package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    private Task5() {

    }

    private static Contact setContact(String[] person) {
        if (person.length > 1) {
            return new Contact(person[0], person[1]);
        } else {
            return new Contact(person[0]);
        }
    }

    public static List<Contact> parseContacts(String[] people, String order) {
        List<Contact> parsedContacts = new ArrayList<>();

        for (String person : people) {
            parsedContacts.add(setContact(person.split(" ")));
        }

        if (order.equals("ASC")) {
            parsedContacts.sort(new ComparatorAsc());
        } else {
            parsedContacts.sort(new ComparatorDesc());
        }
        return parsedContacts;
    }
}
