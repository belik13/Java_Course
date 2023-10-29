package edu.hw3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackwardIteratorTest {
    @Test
    @DisplayName("ExampleTest")
    void ExampleTest() {
        Iterator<Integer> iter = new BackwardIterator<>(List.of(1,2,3));
        List<Integer> check = new ArrayList<>();
        while (iter.hasNext()) {
            check.add(iter.next());
        }
        assertThat(check).isEqualTo(List.of(3,2,1));
    }
}
