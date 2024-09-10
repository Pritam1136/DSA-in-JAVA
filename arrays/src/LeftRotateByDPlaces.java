import java.util.Scanner;

public class LeftRotateByDPlaces {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        d = d % arr.length;
        System.out.println(d);
    }
}
