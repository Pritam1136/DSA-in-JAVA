import java.util.Scanner;

public class charHash {
    static Scanner in = new Scanner(System.in);
    static void characterHashing(char[] arr){
        int [] hash = new int[256];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] += 1;
        }
        int inq =0;
        System.out.println("Enter the numbers of query(ies) :");
        inq = in.nextInt() ;
        while (inq > 0){
            --inq;
            char characters;
            System.out.println("Enter the character(s) :");
            characters =in.next().charAt(0);
//            fetch method
            System.out.println(hash[characters]);

        }
    }
    public static void main(String[] args) {
       int n;
        System.out.println("Enter the length of array :");
        n = in.nextInt();
        char[] arr = new char[n];
        System.out.println("Enter the characters :");
        for (int i = 0; i < arr.length; i++) {
           arr[i] = in.next().charAt(0);
        }
        characterHashing(arr);
    }
}
