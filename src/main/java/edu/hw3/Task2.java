package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task2 {
    private Task2() {

    }

    public static List<String> clusterize(String brackets) {
        Stack<Character> brack = new Stack<Character>();
        StringBuilder currentSequence = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < brackets.length(); ++i) {
            if (brackets.charAt(i) == '(') {
                brack.push('(');
            } else if (brack.peek() == '(') {
                brack.pop();
            }
            currentSequence.append(brackets.charAt(i));
            if (brack.isEmpty()) {
                result.add(currentSequence.toString());
                currentSequence.setLength(0);
            }
        }
        return result;
    }
}
