package org.example.ex8_first_in_list_sorted;

import lombok.*;
/*
Mentiuni onorabile
@RequiredArgsConstructor
@Data
@EqualsAndHashCode
@Log(Oricare anotatie)
 */
@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor

public class EmployeeSorted implements Comparable<EmployeeSorted> {

    private String name;
    private Integer salary;

    /*
    Comparable va sorta automat colectia de valori pe parcurs ce adaugam obiectele in lista.
     */
    @Override
    public int compareTo(EmployeeSorted o) {

        //pt ordine descrescatoare, trb sa sortati dupa elementul other(argumentul) fata de elementul curent
        return Double.compare(o.getSalary(),this.salary) ;
        //ordine crescatoare : return Double.compare(this.salary, o.getSalary())
    }
}
