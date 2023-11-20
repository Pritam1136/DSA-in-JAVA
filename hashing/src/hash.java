import java.util.Scanner;

public class hash {
    static Scanner in = new Scanner(System.in);
    static int[] hash;

    static {
        hash = new int[(int) (1e7 + 1)];
    }

    static void hashing(int[] arr, int n){
        //        precompute
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }
        int query = 0;
        System.out.println("Enter the numbers of query(ies) :");
        query = in.nextInt();
        while (query > 0){
            int number;
            System.out.println("Enter the numbers :");
            number =in.nextInt();
//            fetch method
            System.out.println(hash[number]);
            query--;
        }

    }
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the length of array :");
        n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the elements in array :");
        for (int i = 0; i <n; i++) {
            arr[i] = in.nextInt();
        }
        hashing(arr,n);
    }
}
