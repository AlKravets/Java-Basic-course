// Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.

// Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

// Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.

// Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

// Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

// Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main (String [] args){
        // String strTest1 = "bМама мыла-мыла-мыла aраму!";

        // String strTest2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        // BufferedReader inputReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(strTest2.getBytes()),

                // StandardCharsets.UTF_8));

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        Map<String, Long> wordsFrequency = null;
        try (Stream<String> stream = inputReader.lines() ){
            wordsFrequency = stream.flatMap(line -> Stream.of(line.split("[^a-zA-Zа-яА-Я0-9']+")))
                .map(word -> word.toLowerCase())
                .collect(Collectors.groupingBy(
                            Function.identity(), Collectors.counting())
                    );

        }
        // System.out.println(wordsFrequency.toString());

        Stream<Map.Entry<String,Long>> result = wordsFrequency.entrySet().stream();


            // result.forEach(System.out::println);
            result.sorted((a,b) -> 
                    a.getValue().equals(b.getValue())? a.getKey().compareTo(b.getKey()):b.getValue().compareTo(a.getValue()))
                    .limit(10).forEach(a -> System.out.println(a.getKey().toString()) );

    }

}



// Эталонное решение
//import java.io.IOException;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;
 
// public class Main {

//     public static void main(String[] args) throws IOException {
//         // Для чтения входного потока используем Scanner.
//         // Поскольку словами мы считаем последовательности символов,
//         // состоящие из букв или цифр, то в качестве разделителя слов Scanner'у
//         // указываем регулярное выражение, означающее
//         // "один или более символ, не являющийся ни буквой, ни цифрой".
//         Scanner scanner = new Scanner(System.in, "UTF-8")
//                 .useDelimiter("[^\\p{L}\\p{Digit}]+");

//         // Пройдем по всем словам входного потока и составим Map<String, Integer>,
//         // где ключом является слово, преобразованное в нижний регистр,
//         // а значением - частота этого слова.
//         Map<String, Integer> freqMap = new HashMap<>();
//         scanner.forEachRemaining(s -> freqMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));

//         freqMap.entrySet().stream()                 // получим стрим пар (слово, частота)
//                 .sorted(descendingFrequencyOrder()) // отсортируем
//                 .limit(10)                          // возьмем первые 10
//                 .map(Map.Entry::getKey)             // из каждой пары возьмем слово
//                 .forEach(System.out::println);      // выведем в консоль
//     }

//     // Создание Comparator'а вынесено в отдельный метод, чтобы не загромождать метод main.
//     private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() {
//         // Нам нужен Comparator, который сначала упорядочивает пары частоте (по убыванию),
//         // а затем по слову (в алфавитном порядке). Так и напишем:
//         return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
//                 .reversed()
//                 .thenComparing(Map.Entry::getKey);
//     }
// }