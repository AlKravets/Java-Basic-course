import java.math.BigInteger;

public class Factorial{
    public static void main(String [] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(3));
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = new BigInteger("1");

        for (int i=1; i<= value; ++i){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    // another var
    // return  value == 0 ? BigInteger.ONE : BigInteger.valueOf(value).multiply(factorial (value-1));
    }



}