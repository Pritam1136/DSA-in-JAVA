import java.util.Scanner;

public class searchIn2DArray {
    static int search(int [][] arr, int target){
        int n = arr.length;
        int m = arr[0].length;
        int low = 0, high = (n*m)-1;
        while (low <= high){
           int mid = (low + high) / 2;
           int row = mid / m;
           int column = mid % m;
           if (arr[row][column] == target){
               System.out.println(row);
               System.out.println(column);
               return 1;
           } else if (arr[row][column] < target){
               low = mid + 1;
           } else {
               high = mid - 1;
           }
        }
        return -1;
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the target");
        int target = in.nextInt();
        System.out.println("Enter the number of row");
        int n  = in.nextInt();
        System.out.println("Enter the number of column");
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
       if (search(arr, target) == -1){
           System.out.println("Target not found");
       } else {
           System.out.println("Target found");
       }
    }
}
