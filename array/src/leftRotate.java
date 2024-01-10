import java.util.Scanner;

public class leftRotate {
    static void rotate(int[] arr){
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }
    static int[] rotateByN(int[] arr){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the times element have to rotate:");
        int r = in.nextInt();
        r = r % arr.length;
        int [] temp = new int[r];
        System.arraycopy(arr, 0, temp, 0, r);
        for (int i = r; i < arr.length; i++) {
            arr[i - r] = arr[i];
        }
        for (int i = arr.length -r; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length -r)];
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array:");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the elements of array:");
        for (int i = 0; i <n; i++){
            arr[i] = in.nextInt();
        }
//        rotate(arr);
        int[] answer = rotateByN(arr);
        System.out.println("Array after rotation:");
        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }
    }
}
// TC = O(n)
// SC = O(1)