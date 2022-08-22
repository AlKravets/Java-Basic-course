// Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов, отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.

// На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы.

import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        double res = 0;
        try (Scanner sc = new Scanner(System.in)){
            while (sc.hasNext()){
                if (sc.hasNextDouble()){
                    res += sc.nextDouble();
                } else{
                    sc.next();
                }
                // System.out.printf("%.6f",res);       
            }
        }       
        System.out.printf("%.6f",res);
    }
    

}