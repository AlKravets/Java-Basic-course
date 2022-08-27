
public class Main{
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        java.util.List<Integer> inputData = new java.util.LinkedList<Integer>();

        while(input.hasNextInt()){
            inputData.add(Integer.valueOf(input.nextInt()));
        }

        // System.out.println(inputData.toString());
        deleteEvenIndexes(inputData);
        java.util.Collections.reverse(inputData);
        // System.out.println(inputData.toString());
        inputData.forEach(item -> System.out.print(item + " "));
    }

    public static <T> void deleteEvenIndexes(java.util.List<T> list) {
        java.util.Iterator<T> iter = list.iterator();
        int indexNumber = 0;
        while(iter.hasNext()){
            iter.next();
            if (indexNumber % 2 ==0){
                iter.remove();
            }
            indexNumber++;
        }
    }
    
}



// another variant from comments
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         List<Integer> evenNumbers = new ArrayList<>();

//         int i = 1;
//         Scanner scanner = new Scanner(System.in);
//         while (scanner.hasNextInt()) {
//             int val = scanner.nextInt();

//             if (i++ % 2 == 0) {
//                 evenNumbers.add(val);
//             }
//         }

//         Collections.reverse(evenNumbers);
//         evenNumbers.forEach(x -> System.out.print(x + " "));
//     }
// }