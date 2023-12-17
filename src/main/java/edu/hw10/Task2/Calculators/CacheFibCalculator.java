package edu.hw10.Task2.Calculators;

public class CacheFibCalculator implements CacheCalculator {
    @Override
    public long calculate(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return calculate(number - 1) + calculate(number - 2);
        }
    }
}
