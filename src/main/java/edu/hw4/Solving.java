package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solving {
    private Solving() {

    }

    private static final int TASK_CONSTANT = 100;

    public static List<Animal> sortByHeight(List<Animal> list) {
        return list.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    public static List<Animal> sortByWeight(List<Animal> list, int k) {
        return list.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    public static Map<Animal.Type, Long> countingTypesOfAnimal(List<Animal> list) {
        return list.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    public static Animal theLongestName(List<Animal> list) {
        return list.stream().max(Comparator.comparingInt(ans -> ans.name().length()))
            .orElseThrow();
    }

    public static Animal.Sex popularSex(List<Animal> list) {
        return list.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    public static Map<Animal.Type, Animal> heaviestAnimalInType(List<Animal> list) {
        return list.stream().collect(Collectors.toMap(Animal::type, Function.identity(),
            (list1, list2) -> list1.weight() >= list2.weight() ? list1 : list2
        ));
    }

    public static Animal kThOldestAnimal(List<Animal> list, long k) {
        return list.stream().sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k)
            .toList()
            .get(0);
    }

    public static Optional theHeaviestAnimalBeforeKCm(List<Animal> list, int k) {
        return list.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static int numberOfBites(List<Animal> list) {
        return list.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> animalsWithAgeNotEqualWithPaws(List<Animal> list) {
        return list.stream()
            .filter(animal -> animal.paws() != animal.age())
            .toList();
    }

    public static List<Animal> animalsWithBitesAndHeight(List<Animal> list) {
        return list.stream()
            .filter(animal -> animal.bites() && animal.height() > TASK_CONSTANT)
            .toList();
    }

    public static int cntAnimalsWithWeightMoreThanHeight(List<Animal> list) {
        return (int) list.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    public static List<Animal> animalsWithNameMoreThanTwoWords(List<Animal> list) {
        return list.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    public static boolean dogWithHeightMoreThanK(List<Animal> list, int k) {
        return list.stream()
            .filter(animal -> animal.type().equals(Animal.Type.DOG) && animal.height() < k)
            .toList()
            .isEmpty();
    }

    public static Map<Animal.Type, Integer> sumWeightOfEachType(List<Animal> list, int k, int i) {
        return list.stream()
            .filter(animal -> animal.age() > k && animal.age() < i)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> sortedList(List<Animal> list) {
        return list.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    public static boolean ifSpidersBiteMoreThanDogs(List<Animal> list) {
        long spiderBites = list.stream()
            .filter(animal -> animal.type().equals(Animal.Type.SPIDER) && animal.bites()).count();
        long dogBites = list.stream()
            .filter(animal -> animal.type().equals(Animal.Type.DOG) && animal.bites()).count();
        return dogBites < spiderBites;
    }

    public static Animal theHeaviestFishInLists(List<Animal>... list) {
        return Arrays.stream(list).flatMap(List::stream)
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    public static Map<String, Set<ValidationError>> animalsWithMistakes(List<Animal> list) {
        return list.stream()
            .filter(animal -> !Validator.getErrors(animal).isEmpty())
            .collect(Collectors.toMap(Animal::name, Validator::getErrors));
    }

    public static Map<String, String> readableAnimalsWithMistakes(List<Animal> input) {
        return input.stream()
            .filter(animal -> !Validator.getErrors(animal).isEmpty())
            .collect(
                Collectors.toMap(
                    Animal::name,
                    t ->
                        Validator.getErrors(t).stream()
                            .map(ValidationError::getMessage)
                            .collect(Collectors.joining("\n"))
                )
            );
    }
}

