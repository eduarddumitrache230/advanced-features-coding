package org.example.ex5_string_manip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
    Given a list of strings, write a method that returns a list of all strings that start with the
    letter 'a' (lower case) and have exactly 3 letters using streams

    Req:
    -strings that starts with the letter a
    -have exactlu 3 letters

    Input: ana,are,mere,alune,banane.cai,si,boi
    Output:ana,are

    Metoda 1 : iterativ cu for
    Metoda 2 : stream
*/
public class StringManip {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>(List.of("ana","are","mere","alume","banane","cai","si","boi"));

        System.out.println("Elementele sunt: " + methodWithFor(words) );
        System.out.println("Elementele sunt: " + methodWithStreamFillter(words) );
        System.out.println("Elementele sunt: " + methodWithStreamColectors(words) );
    }

    private static List<String> methodWithStreamFillter(List<String> words) {

        return words.stream()
                .filter(it -> it.startsWith("a") && it.length() == 3)
                .collect(Collectors.toList());
    }

    private static List<String> methodWithStreamColectors(List<String> words) {
        return words.stream()
                .collect(Collectors.filtering(it ->it.startsWith("a") && it.length()==3, Collectors.toList()));
    }

    private static List<String> methodWithFor(List<String> words) {
        char letter = 'a';

        List<String> result = new ArrayList<>();

        for (String currentWord : words){

            if (currentWord.startsWith(String.valueOf(letter)) && currentWord.length() == 3) {
                result.add(currentWord);

            }

        }

        return result;

    }
}
