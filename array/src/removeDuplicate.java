import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class removeDuplicate {
   static void remove(int[] arr) {
       Set<Integer> duplicate = new HashSet<>();
       for (int j : arr) {
           duplicate.add(j);
       }
       for (Integer integer : duplicate) {
           System.out.println(integer);
       }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of array:");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter array element :");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        remove(arr);
    }
}
