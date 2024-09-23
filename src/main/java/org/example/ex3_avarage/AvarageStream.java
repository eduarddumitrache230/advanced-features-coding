package org.example.ex3_avarage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
    Write a method that returns the average of a list of integers using streams

    1 5 2 4 9 -> media aritmetica = (1 + 5 + 2 + 4 + 9)/5 = 4.2

    Metoda 1 :
    - .stream() => convert la un stream de date -> Stream<Double>
    -  .maptodouble(argument) => convert la DoubleStream
    - .average() => face reductia listei la o suma a elementelor + imparte suma la nr total de elemente
    - folosim reduce
    - calculam cate numere sunt in array

*/
public class AvarageStream {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,5,2,4,9);

        System.out.println("Average of list is: " + calculateAvgStream(list));
        System.out.println("Average of list is: " + calculateAvgFor(list));

    }

    private static Double calculateAvgFor(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return (double) sum/list.size();
    }

    private static Double calculateAvgStream(List<Integer> list) {

        //Optional<> = un obiect optional are capacitatea de a stocare o valoare inclusiv nula
        // noi putem sa extragem valoarea optional daca e prezenta

//        Optional<Double> obj  = Optional.of(10.2);
//        Optional<Double> obj2  = Optional.of(null);




       /*
        Intotdeauna cand faceti conversii repetate in contextul streamurilor, aveti grija sa pastrati tipul de date al
        colectiei originale
        */
        return  list.stream()
                .mapToDouble(Integer ::doubleValue)// Integer:: doubleValue -> nu Double::doubleValue
                .average()
                .orElse(0.0); // sau getAsDouble() nu face verificare de prezenta a valorii in avarage
        // daca valoarea in avarage este prezenta(!null) va intoarce valoarea.
        //totusi daca avarage este null, va arunca o exceptie
        //orElse preia exceptia si in loc sa o arunce, trimite o valoare default

    }

}
