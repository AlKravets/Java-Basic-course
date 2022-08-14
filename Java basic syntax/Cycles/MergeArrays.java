import java.util.Arrays;
/*
 * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.

Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив. Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась. К сожалению, автоматически это не проверить, так что это остается на вашей совести :)
 * 
 */
public class MergeArrays{
    public static void main(String [] args) {
        int[] res = mergeArrays(new int[] {0,2,2}, new int[] {1,3});
        System.out.println(Arrays.toString(res));
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int i = 0, j = 0;
        for (int k =0; k< result.length; ++k){
            if (j == a2.length || (i != a1.length && a1[i] < a2[j])){
                result[k] = a1[i];
                ++i;
            } else { 
                result[k] = a2[j];
                ++j;
            }
        }
        return result;
    }
}

// variant from comments
// public static int[] mergeArrays(int[] a1, int[] a2) {
//     int n = a1.length, m = a2.length;
//     int i = 0, j = 0;
//     int[] array = new int[n + m];

//     while (i < n || j < m)
//         array[i + j] = (i < n && (j == m || a1[i] < a2[j])) ? a1[i++] : a2[j++];

//     return array;
// }