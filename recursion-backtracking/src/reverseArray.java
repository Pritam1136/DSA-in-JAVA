import java.util.Scanner;

public class reverseArray {
    static void swap(int l, int r, int[] arr){
        int temp = 0;
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    static void reverse(int l, int r, int[] arr){
        if (l > r){
            return;
        }
        swap(l, r, arr);
        reverse(l+1, r -1, arr);
    }

//    static void reverseWithOneParam(int[] arr){
//        int j = (int) (arr.length-1) /2;
//        int i =-1;
//        i++;
//        if (i > (arr.length -1) /2){
//           return;
//        }
//        swap(arr.length-i-1, i , arr );
//        reverseWithOneParam(arr);
//    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int[] arr = new int[5];
            System.out.println("Enter the numbers in array.");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println("Array before swapping :");
            for (int k : arr) {
                System.out.println(k);
            }
            reverse(0, arr.length -1, arr);

//        reverseWithOneParam(arr);

            System.out.println("Array after swapping :");
            for (int j : arr) {
                System.out.println(j);
            }
        }
    }
}
