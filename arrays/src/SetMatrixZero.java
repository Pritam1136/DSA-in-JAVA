import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1},{1,1,0,1},{1,1,1,1},{1,1,1,1}};
        int col0 = 1;
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0){
                    arr[i][0] = 0;

                    if (j != 0)
                        arr[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        for (int i = 1; i < arr[0].length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] != 0){
                    if (arr[0][j] == 0 || arr[i][0] == 0){
                        arr[i][j] = 0;
                    }
                }
            }
        }
        if (arr[0][0] == 0){
            for (int j = 0; j < arr.length; j++) {
                arr[0][j] = 0;
            }
        }
        if (col0 == 0){
            for (int i = 0; i < arr[0].length; i++) {
                arr[i][0] = 0;
            }
        }
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
