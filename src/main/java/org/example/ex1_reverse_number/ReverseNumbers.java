package org.example.ex1_reverse_number;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    Reverse a number using while Loop.
    The program will prompt user to input the number,
    and then it will reverse the same number using while loop.

    8765 - 5678
    Metoda 1:
    while(???){
    }
    Metoda2:
    array = {8,7,6,5}
    parcurs invers

    Metoda3
    8765 -> toString -> List<Character>

    ce e complexitatea? De ce alegem varianta 1 in locul lui 2 si 3?

*/
public class ReverseNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numarul reversibil");

        int number = scanner.nextInt();

        System.out.println("Solution 1: " + getReverseNumberM1(number));
        System.out.println("Solution 2: " + getReverseNumberM2(number));
        System.out.println("Solution 3: " + getReverseNumberM3(number));

    }

    private static int getReverseNumberM1(int number) {
        /*
        8765
        while(number>0){
        -extragem restul cu number %10 -> 5
        -eliminam cifra unitatilor cu number/10 -> 876
        -reconstructia numarului - reverseNumber *10 + rest
         */
        int reverseNumber = 0; // o asignare de valoare are complexitate liniara O(1)

        // o repetitie care se parcurge de n ori, n = number.lenght()
        // pentru a face o repetitie completa de la 0 la n, adica parcurgem cifrele numarului, complexitatea este O(n)


        while (number > 0) {
            int rest = number % 10;
            number = number / 10; //number/=10
            reverseNumber = reverseNumber * 10 + rest;

        }
        return reverseNumber;
    }

    private static int getReverseNumberM2(int number) {
        List<Integer> numberDigits = new ArrayList<>();
        int reversedNumber = 0;

        //O(n) -> de ce ? pentru ca facem o repetitie completa de la 0 la number.size -1 =n
        for (int i = 0; number > 0; i++) {
            numberDigits.add((number % 10));
            number /= 10;
        }
        System.out.println("Number Digits: " + numberDigits);

        //0(n) -> parcurgem in intregime lista de la 0 la number.Digits.size() -1
        for (Integer it : numberDigits) {
            reversedNumber = reversedNumber * 10 + it;
        }

        //Complexitatea totala se calculeaza prin adunare: O(n) * O(n) = 2*O(n) = O(n)
        return reversedNumber;
    }

    private static int getReverseNumberM3(int number) {
        int reversedNumber = 0;
        String reversedString = ""; // empty string este echivalentul lui 0
        String numberStr = Integer.toString(number);
        int index = Integer.toString(number).length() - 1; //genul acesta de metode e utilizat pt conversia tipului de date
        //intre wrappere
        //Salvam lungimea sirului de caractere pentru ca este relevanta in determinarea indexului ultimului caracter.
        //Sirul de caractere cunoscut sub numele de String are indexare de la 0.
        //poz 0 = 8
        //poz 1 = 7
        //poz 2 = 6
        //poz 3 = 5
        //metoda lenght intoarce lungimea totala a sirului = 4 , index = lenght -1 = 3

        //Primul while asigura o repetitie completa -> O(n)
        while (index >= 0) {
            //Concatenarea in Java este o procedura de creare iterativa a unui sir de caractere -> O(n)
            reversedString = reversedString + numberStr.charAt(index);
            index--;
        }
        //Complexitatea totala este 0(n) * O(n) = O(n^2)

        reversedNumber = Integer.parseInt(reversedString); //conversie de la String la int
        return reversedNumber;
    }

    /* Daca numarul are zerouri  in extremitati  1990
    S1: reconstituire inversa sub forma de String -> seamana cu M3 alterat
    S2: salvarea cifrelor intr-o lista si parcurgerea ei, Dar in modul asta nu vom avea o valoare individuala ->
    seamana cu M2 alterat
     */

    // todo: aplicati acelasi algoritm de reconstructie de numere intregi similiar cu M1 in mod recursiv
    // todo: aplicati notiunile de stream-uri pentru prelucrarea inversa a cifrelor si reductia rezultatului final intr-un Integer

}