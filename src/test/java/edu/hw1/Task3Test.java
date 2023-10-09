package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Проверка на пустых массивах")
    void neastedArrays() {
        int testArray[] = new int[] {};
        int testArray2[] = new int[] {};

        boolean ans = Task3.isNestable(testArray,testArray2);

        assertThat(ans).isEqualTo(false);
    }
    @Test
    @DisplayName("Проверка на true")
    void neastedArrayTrue() {
        int testArray[] = new int [] {1,2,3,4};
        int testArray2[] = new int [] {0,6};

        boolean ans = Task3.isNestable(testArray,testArray2);

        assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("Проверка на false")
    void neastedArrayFalse() {
        int testArray[] = new int [] {9,9,8};
        int testArray2[] = new int [] {8,9};

        boolean ans = Task3.isNestable(testArray,testArray2);

        assertThat(ans).isEqualTo(false);
    }
    @Test
    @DisplayName("Test2")
    void neastedArrayTrue2() {
        int testArray[] = new int [] {3,1};
        int testArray2[] = new int [] {4,0};

        boolean ans = Task3.isNestable(testArray,testArray2);

        assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("Проверка на false2")
    void neastedArrayFalse2() {
        int testArray[] = new int [] {1,2,3,4};
        int testArray2[] = new int [] {2,3};

        boolean ans = Task3.isNestable(testArray,testArray2);

        assertThat(ans).isEqualTo(false);
    }


}
