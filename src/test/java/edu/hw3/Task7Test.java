package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("TreeMap with null key")
    void TreeMapWithNullKey() {
        TreeMap<String, String> tree =new TreeMap<>(new Task7<>());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}
