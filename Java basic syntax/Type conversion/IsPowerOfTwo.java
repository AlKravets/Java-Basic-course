/*
 * Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.

Решать можно разными способами:

воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
применив пару трюков из двоичной арифметики;
написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой задаче после просмотра соответствующих уроков).
Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
 * 
 * 
 */

public class IsPowerOfTwo{
    public static void main(String [] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(-2));
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
public static boolean isPowerOfTwo(int value) {
    return Integer.bitCount(Math.abs(value)) == 1;
    // Побитовое сложение степени двойки и предыдущего двоичного числа даст ноль.
    // another variant
    // value = Math.abs(value);
    // return ((value & (value - 1)) == 0) & (0 != value);// you implementation here
}

}