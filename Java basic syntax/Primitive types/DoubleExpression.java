/*
 * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
Допустимая погрешность – 0.0001 (1E-4)

Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
 * 
 * 
 */

public class DoubleExpression{
    public static void main(String [] args) {
        System.out.println(doubleExpression(0.1,0.2,0.3));
    }

    public static boolean doubleExpression(double a, double b, double c) {
        double delta = 1e-4;
        return Math.abs(a + b - c) <= delta;
    }

}