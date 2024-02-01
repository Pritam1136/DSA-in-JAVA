import java.util.Scanner;

public class steps {
    static int count(int a, int helper){
        if (a == 0){
            return helper;
        }
        helper ++;
        if (a % 2 == 0){
            return count(a/2, helper);
        } else {
            return count(a - 1 , helper);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int a = in.nextInt();
        int b = count(a, 0);
        System.out.println("Number of steps are : " + b);
    }
}
