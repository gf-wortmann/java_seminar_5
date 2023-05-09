package org.example.HomeTask_1;

import java.util.HashMap;

/*1) Подсчитать количество искомого слова, через map (наполнением значение, где искомое слово будет являться ключом),
вносить все слова не нужно

Пример:
Россия идет вперед всей планеты. Планета — это не Россия.
Запрос: Россия
Ответ: Россия - 2

 */
public class HomeTask_1 {
    public static void main ( String[] args ) {
        String inputText = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String[] strings = inputText.replaceAll ( "[^a-zA-Zа-яА-Я ]" , "" ).split ( " " );
        HashMap < String, Integer > words = new HashMap <> ( strings.length );
        String searchString = "Россия";

        for ( String string : strings ) {
            if ( string.length ( ) > 0 ) {
                words.putIfAbsent ( string , 0 );
                words.put ( string , words.get ( string ) + 1 );
            }
        }
        System.out.printf ( "Слово \"%s\" встречается в тексте %d раз." , searchString , words.get ( searchString ) );
    }
}
