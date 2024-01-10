import java.util.Scanner;

public class IsSorted {
    static boolean sorted(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]){

            }
            else {
                return false;
            }
        }
        return true;
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
       if (sorted(arr)){
           System.out.println("Sorted");
       }
       else {
           System.out.println("not sorted");
       }
    }
}
