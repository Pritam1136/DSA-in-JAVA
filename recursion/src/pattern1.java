import java.util.Scanner;

public class pattern1 {
    static void print(int row){
        if (row == 0)
            return;
        for (int i = 1; i <= row; i++) {
            System.out.print("*");
        }
        System.out.println();
        print(--row);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        print(n);
    }
}
