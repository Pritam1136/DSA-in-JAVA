import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        sum();
    }
     static void sum(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number 1 :");
        int s1 = in.nextInt();
        System.out.println("Enter number 2 :");
        int s2 = in.nextInt();
        int sum = s1 + s2;
        System.out.println("Sum =" + sum);
    }
}