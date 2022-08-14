public class IsPalindrome{
    public static void main(String [] args) {
        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    /** 
    * Checks if given <code>text</code> is a palindrome.   
    *
    * @param text any string
    * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
    */
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        text = text.toLowerCase();
        StringBuilder reversText = new StringBuilder(text);
        reversText.reverse();
        return text.equals(reversText.toString());
    }
}



//variant from comments
// public static boolean isPalindrome(String text) {
//     String result = text.replaceAll("[^a-zA-Z0-9]", "");
//     return result.equalsIgnoreCase(new StringBuilder(result).reverse().toString());
// }
