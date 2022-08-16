public class Main{
    public static void main(String [] args) {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        // a.equals(b) must return true
        // a.hashCode() must be equal to b.hashCode()
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() + ", " + b.hashCode());
    }

}