package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static edu.hw4.Solving.animalsWithAgeNotEqualWithPaws;
import static edu.hw4.Solving.animalsWithBitesAndHeight;
import static edu.hw4.Solving.animalsWithMistakes;
import static edu.hw4.Solving.animalsWithNameMoreThanTwoWords;
import static edu.hw4.Solving.cntAnimalsWithWeightMoreThanHeight;
import static edu.hw4.Solving.countingTypesOfAnimal;
import static edu.hw4.Solving.dogWithHeightMoreThanK;
import static edu.hw4.Solving.heaviestAnimalInType;
import static edu.hw4.Solving.ifSpidersBiteMoreThanDogs;
import static edu.hw4.Solving.kThOldestAnimal;
import static edu.hw4.Solving.numberOfBites;
import static edu.hw4.Solving.popularSex;
import static edu.hw4.Solving.readableAnimalsWithMistakes;
import static edu.hw4.Solving.sortByHeight;
import static edu.hw4.Solving.sortByWeight;
import static edu.hw4.Solving.sortedList;
import static edu.hw4.Solving.sumWeightOfEachType;
import static edu.hw4.Solving.theHeaviestAnimalBeforeKCm;
import static edu.hw4.Solving.theHeaviestFishInLists;
import static edu.hw4.Solving.theLongestName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    Animal c = new Animal("Korova",Animal.Type.CAT, Animal.Sex.F,4,50,30,true);
    Animal c1 = new Animal("Belka",Animal.Type.DOG, Animal.Sex.F,40,30,22,true);
    Animal c2 = new Animal("Strelka",Animal.Type.SPIDER, Animal.Sex.F,30,20,60,true);
    List<Animal> list = new ArrayList<>(List.of(c,c1,c2));

    @Test
    @DisplayName("Task1")
    void task1Test() {
        assertThat(sortByHeight(list)).isEqualTo(List.of(c2,c1,c));
    }

    @Test
    @DisplayName("Task2")
    void task2Test() {
        assertThat(sortByWeight(list,1)).isEqualTo(List.of(c2));
    }

    @Test
    @DisplayName("Task3")
    void task3Test() {
        Map<Animal.Type, Long> excepted = new HashMap<>();

        excepted.put(Animal.Type.CAT,1L);
        excepted.put(Animal.Type.DOG,1L);
        excepted.put(Animal.Type.SPIDER,1L);

        assertThat(countingTypesOfAnimal(list)).isEqualTo(excepted);
    }

    @Test
    @DisplayName("Task4")
    void task4Test() {
        assertThat(theLongestName(list)).isEqualTo(c2);
    }

    @Test
    @DisplayName("Task5")
    void task5Test() {
        assertThat(popularSex(list)).isEqualTo(Animal.Sex.F);
    }

    @Test
    @DisplayName("Task6")
    void task6Test() {
        Map<Animal.Type, Animal> excepted = new HashMap<>();

        excepted.put(Animal.Type.DOG, c1);
        excepted.put(Animal.Type.SPIDER,c2);
        excepted.put(Animal.Type.CAT,c);

        assertThat(heaviestAnimalInType(list)).isEqualTo(excepted);
    }

    @Test
    @DisplayName("Task7")
    void task7Test() {
        assertThat(kThOldestAnimal(list,0)).isEqualTo(c1);
    }

    @Test
    @DisplayName("Task8")
    void task8Test() {
        assertThat(theHeaviestAnimalBeforeKCm(list,30)).isEqualTo(Optional.of(c2));
    }

    @Test
    @DisplayName("Task9")
    void task9Test() {
        assertThat(numberOfBites(list)).isEqualTo(16);
    }

    @Test
    @DisplayName("Task10")
    void task10Test() {
        assertThat(animalsWithAgeNotEqualWithPaws(list)).isEqualTo(List.of(c1,c2));
    }

    @Test
    @DisplayName("Task11")
    void task11Test() {
        assertThat(animalsWithBitesAndHeight(list)).isEqualTo(List.of());
    }

    @Test
    @DisplayName("Task12")
    void task12Test() {
        assertThat(cntAnimalsWithWeightMoreThanHeight(list)).isEqualTo(1);
    }

    @Test
    @DisplayName("Task13")
    void task13Test() {
        Animal test = new Animal("Pu sh Ok", Animal.Type.CAT, Animal.Sex.F,25,25,20,true);
        assertThat(animalsWithNameMoreThanTwoWords(List.of(test))).isEqualTo(List.of(test));
    }

    @Test
    @DisplayName("Task14")
    void task14Test() {
        assertThat(dogWithHeightMoreThanK(list,25)).isEqualTo(true);
    }

    @Test
    @DisplayName("Task15")
    void task15Test() {
        Map<Animal.Type, Integer> excepted = new HashMap<>();

        excepted.put(Animal.Type.DOG, 22);

        assertThat(sumWeightOfEachType(list,35,45)).isEqualTo(excepted);
    }

    @Test
    @DisplayName("Task16")
    void task16Test() {
        assertThat(sortedList(list)).isEqualTo(List.of(c,c1,c2));
    }

    @Test
    @DisplayName("Task17")
    void task17Test() {
        assertThat(ifSpidersBiteMoreThanDogs(list)).isEqualTo(false);
    }

    @Test
    @DisplayName("Task18")
    void task18Test() {
        List<Animal> list1 = new ArrayList<>();
        list1.add(new Animal("Gold fish", Animal.Type.FISH, Animal.Sex.M,2,1,100,false));

        List<Animal> list2 = new ArrayList<>();
        list2.add(new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M,2,1,200,false));

        assertThat(theHeaviestFishInLists(list,list1,list2)).isEqualTo(list2.get(0));
    }

    @Test
    @DisplayName("Task19")
    void task19Test() {
        List<Animal> test = new ArrayList<>();
        test.add(new Animal("Gold fish", Animal.Type.FISH, Animal.Sex.M,-5,1,100,false));

        Map<String, Set<ValidationError>> excepted = new HashMap<>();
        excepted.put("Gold fish", Set.of(new ValidationError("Animal can't have negative age")));

        assertThat(animalsWithMistakes(test)).isEqualTo(excepted);
    }

    @Test
    @DisplayName("Task20")
    void task20Test() {
        Map<String, String> excepted = new HashMap<>();

        excepted.put("Gold fish","Animal can't have negative age\nAnimal can't have negative or zero height");

        List<Animal> test = new ArrayList<>();
        test.add(new Animal("Gold fish", Animal.Type.FISH, Animal.Sex.M,-5,-5,100,false));

        assertThat(readableAnimalsWithMistakes(test)).isEqualTo(excepted);
    }
}
