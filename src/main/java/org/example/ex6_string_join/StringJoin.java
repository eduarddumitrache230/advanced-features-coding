package org.example.ex6_string_join;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Write a method that returns a comma-separated string based on a given list of integers.
    Each element should be preceded by the letter 'e' if the number is even, and preceded by
    the letter 'o' if the number is odd. For example, if the input list is (3,44), the output
    should be 'o3,e44'. Use streams

    Req:
    -elements proceded by letter e if the number is even(numar par)
    -elements proceded by letter o if the number is even(numar impar)
    -final output is concatenation
    Input:
    List={3,44,2,5}
    Output: String = "o3,e44,e2,o5"
 */
public class StringJoin {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 44, 2, 5));
        System.out.println("Metoda prin for: " + methodFor(numbers));
        System.out.println("Metoda prin for: " + methodFor2(numbers));
        System.out.println("Metoda prin for: " + methodStreams(numbers));

    }

    private static String methodFor2(List<Integer> numbers) {
        List<String> result = new ArrayList<>();

        for (Integer it : numbers) {
            result.add(convertIntToStrForm(it));
        }

        return String.join(",", result); //join preia elementele si pune "," intre ele
    }

    private static String methodStreams(List<Integer> numbers) {
        return numbers.stream()
                .map(it -> convertIntToStrForm(it))
                .collect(Collectors.joining(","));
    }

    private static String convertIntToStrForm(Integer value) {
        if (value % 2 == 0) {
            return "e" + value;
        } else {
            return "o" + value;
        }

    }

    private static List<String> methodFor(List<Integer> numbers) {
        List<String> numbersToString2 = new ArrayList<>();

        for (Integer currentNumbers : numbers) {
            if (currentNumbers % 2 == 0) {
                String par = "e" + currentNumbers;
                numbersToString2.add(par);
            } else {
                String impar = "o" + currentNumbers;
                numbersToString2.add(impar);
            }

        }
        return numbersToString2;
    }
}
