import java.util.Set;
// import java.util.HashSet;

public class Main{
    public static void main(String[] args) {
        Set<Integer> set1 = new  java.util.HashSet<Integer>();
        set1.add(Integer.valueOf(1));
        set1.add(Integer.valueOf(2));
        set1.add(Integer.valueOf(3));

        Set<Integer> set2 = new  java.util.HashSet<Integer>();
        set2.add(Integer.valueOf(0));
        set2.add(Integer.valueOf(1));
        set2.add(Integer.valueOf(2));

        
        Set<Integer>  res = symmetricDifference(set1, set2);
        System.out.println(res.toString());

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> union = new java.util.HashSet<T>(set1);
        union.addAll(set2);
        

        Set<T> xorSet = new java.util.HashSet<T>();
        for (T element : union){
            if (set1.contains(element) ^ set2.contains(element)){
                xorSet.add(element);
            }
        }
        return xorSet;
    }
    
}


// another variant from comments
// public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

//     Set<T> answer = new HashSet<>(set1);
//     Set<T> help = new HashSet<>(set2);
//     answer.removeIf(help::remove);
//     answer.addAll(help);
//     return answer;
// }