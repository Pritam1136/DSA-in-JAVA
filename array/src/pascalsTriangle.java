import java.util.Scanner;

public class pascalsTriangle {
    static long nCr (int r, int c){
        long res = 1;
        for (int i = 0; i < c; i++) {
            res = res * (r - i);
            res = res / (i + 1);
        }
        return res;
    }
    static void TellTheElementGivenRowAndColumn(int row, int column){
//        TC: O(column)
//        SC: O(1)
        System.out.println(nCr(row - 1, column - 1));
    }
    static void PrintTheGivenRowOfPascalsTriangle(int n) {  // ex- 1, 5, 10, 10, 5, 1
        int ans = 1;
        System.out.println(ans);
        for (int i = 1; i < n; i++) {
//            System.out.println(nCr(n - 1, i - 1));
            ans = ans * (n - i);
            ans = ans / i;
            System.out.println(ans);
        }
    }
    static void PrintTheEntirePascalTriangleGivenRow(int row){
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(nCr(i - 1, j -1) + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of row:");
        int row = in.nextInt();
        System.out.println("Enter the number of column:");
        int column = in.nextInt();
        TellTheElementGivenRowAndColumn(row, column);
        System.out.println("---------------------------------------------------------------------------");
        PrintTheGivenRowOfPascalsTriangle(row);
        System.out.println("---------------------------------------------------------------------------");
        PrintTheEntirePascalTriangleGivenRow(row);
    }
}
