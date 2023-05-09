package org.example.HomeTask_2;
/*
2) Пусть дан список сотрудников:
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HomeTask_2 {
    public static void main ( String[] args ) {

        String[] persons = {"Иван Иванов"
                , "Светлана Петрова"
                , "Кристина Белова"
                , "Анна Мусина"
                , "Анна Крутова"
                , "Иван Юрин"
                , "Петр Лыков"
                , "Павел Чернов"
                , "Петр Чернышов"
                , "Мария Федорова"
                , "Марина Светлова"
                , "Мария Савина"
                , "Мария Рыкова"
                , "Марина Лугова"
                , "Анна Владимирова"
                , "Иван Мечников"
                , "Петр Петин"
                , "Иван Ежов"
                };
        HashMap <String, Integer> unsortedPersons = new HashMap <> ( persons.length );
        for ( String person : persons ) {
            String name = person.split ( " " )[0];
            unsortedPersons.putIfAbsent ( name , 0 );
            unsortedPersons.put ( name , unsortedPersons.get ( name ) + 1 );
        }
        System.out.println ( "unsortedPersons = " + unsortedPersons );

        HashMap <String, Integer> sortedPersons = unsortedPersons.entrySet ()
                .stream ()
                .sorted (Comparator.comparingInt ( e-> -e.getValue ( ) ))
                .collect ( Collectors.toMap (Entry::getKey, Entry::getValue, ((a, b) -> b), LinkedHashMap::new));
        System.out.println ( "sortedPersons = " + sortedPersons );
    }
}
