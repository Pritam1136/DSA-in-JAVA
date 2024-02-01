import java.util.Scanner;

public class numOfZero {
    static int count(int a, int helper){
        if (a == 0){
            return helper;
        }
        int d = a % 10;
        if (d == 0)
            helper ++;
        return count(a/10, helper);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int a = in.nextInt();
        int b = count(a, 0);
        System.out.println("Number of zeros are : " + b);
    }
}
