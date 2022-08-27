// Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:

// Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
// Первый элемент последовательности устанавливается равным этому числу.
// Следующие элементы вычисляются по рекуррентной формуле R_{n+1}=\mathrm{mid}(R_{n}^2)R 
// n+1
// ​
//  =mid(R 
// n
// 2
// ​
//  ), где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, \mathrm{mid}(123456) = 345mid(123456)=345.
// Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)

// Пример

// pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:

// 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

import java.util.stream.IntStream;

public class Main{
    public static void main(String [] args){
        IntStream test = pseudoRandomStream(13);
        test.limit(10).forEach(System.out::println);

    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, s -> mid(s*s));
    }

    public static int mid (int n){
        return (n % 10_000 - n % 10) / 10;
    }
}


// var from comments
// public static IntStream pseudoRandomStream(int seed) {
//     return IntStream.iterate(seed, n -> (n * n / 10) % 1000);
// }