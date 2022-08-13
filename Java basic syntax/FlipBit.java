/*
 * Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное. Данная задача актуальна, например, при работе с битовыми полями.

Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).
 * 
 */

public class FlipBit{
    public static void main(String [] args) {
        System.out.println(flipBit(0,1));
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        int mask = 0b1;
        mask = mask << bitIndex-1; // all 0 but 1 in bitIndex
        // (value & ~mask) = value but in bitIndex is 0
        // (~(value | ~mask)) = 0 but in bit index = flipped value
        return (value & ~mask) | (~(value | ~mask));

        // return  value ^ 1 << bitIndex-1; // better variant from comments
    }

}