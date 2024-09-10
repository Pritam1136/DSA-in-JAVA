import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateByDPlaces {
    static void ro(int[] arr, int i, int j){
        while (i <j ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static void rotate(int[] arr, int d){
        ro(arr, 0, d-1);
        ro(arr, d, arr.length-1);
        ro(arr, 0, arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        d = d % arr.length;
        rotate(arr, d);
        System.out.println(Arrays.toString( arr ));
    }
}
