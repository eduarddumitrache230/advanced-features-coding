package org.example.ex4_uppercase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    Write a method that converts all strings in a list to their upper case using streams.

    Metoda1:
    -stream
    -toUpperCase per fiecare element
    -map

    Metoda2:
    -for
    -toUpperCase?
    -get element pe pozitita i, set cu upperCase

    Metoda 3:

    -extra, uitati va la functionalitatile din String
*/
public class UpperCaseStream {
    public static void main(String[] args) {

        List<String> text = new ArrayList<>(List.of("ana","are","mere"));

        displayText(text);

        System.out.println("Elementele to upperCase " + upperCaseForStringB(text));
        System.out.println("Elementele to upperCase " + upperCaseFor(text));
        System.out.println("Elementele to upperCase " + upperCaseStream(text));
        System.out.println("Elementele to upperCase " + "upperCaseStream");

        /*
        Keyoword final ne permite sa cream portiuni de cod CONSTANTE

        cand o colectie de valori/elemente/obiecte este constanta, se numeste IMUTABILA
        cand o colectie este variabila este MUTABILA

        in momentul in care aveti metode void, si pasati anumite argumente din mail in aceasta, toate modificarile
        asupra lor in metoda se vor propaga inapoi in main
        de ce? pentru ca argumentul va crea o copie a referintei in memorie, si obiectul din argument
        va coexista in 2 locuri

        -odata in main
        -odata in metoda

        prin urmare ce prelucari se vor intampla in metoda, vor aparea si in main
         */
        upperCaseString(text);
        displayText(text);
    }

    private static void upperCaseString(List<String> text) {
        text.replaceAll(it-> it.toUpperCase()); // String::toUpperCase
    }

    private static void displayText(List<String> listOfTexts){
        for (String it: listOfTexts){
            System.out.print(it + " ");
        }
        System.out.println();
    }
    private static String upperCaseFor(List<String> text) {
        String textUpper = " ";

        for (int i = 0; i < text.size(); i++) {

            textUpper += text.get(i).toUpperCase() + " ";

        }
        return textUpper.trim();
    }

    private static String upperCaseForStringB(List<String> text) {

        StringBuilder textUpper = new StringBuilder();


        for (int i = 0; i < text.size(); i++) {

            textUpper.append(text.get(i).toUpperCase()).append(" ");

        }
        return textUpper.toString().trim(); //metoda toString() se comporta ca un getter pentru StringBuilder
        //care e un wrapper peste String
    }

    private static String upperCaseStream(List<String> text) {

        return text.stream()
                .map(it -> it.toUpperCase())
                .collect(Collectors.joining(" "));
    }



}
