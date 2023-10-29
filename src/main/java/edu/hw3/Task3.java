package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    private Task3() {

    }

    public static <T> Map<T, Long> freqDict(List<T> objToCount) {
        HashMap<String, Integer> result = new HashMap<>();
        return objToCount.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
    }
}
