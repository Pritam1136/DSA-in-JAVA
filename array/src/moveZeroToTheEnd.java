import java.util.Scanner;

public class moveZeroToTheEnd {
    static void moveZero(int[] arr){
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                j = i;
                break;
            }
        }
        for (int i = j+1; i < arr.length; i++) {
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
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
        moveZero(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
//TC = O(n)
//SC = O(1)

