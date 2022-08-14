public class BooleanExpression{
    public static void main(String [] args) {
        System.out.println(booleanExpression(true, true, true,true));
        System.out.println(booleanExpression(true, true, false,false));
        System.out.println(booleanExpression(false, false, true,true));
        System.out.println(booleanExpression(false, false, false, false));
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a ^ b) & (c ^ d) | (a & b) & !(c | d) | !(a | b) & (c & d);
        // return (a ^ b) &(c ^ d)|(a ^ c) &(b ^ d); // better variant from comments
    }
    

}