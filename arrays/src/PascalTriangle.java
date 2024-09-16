public class PascalTriangle {
    static int nCr(int n, int r){
       int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
    static void EntireRow(int row){
        int ans = 1;
        System.out.println(ans);
        for (int i = 1; i < row; i++) {
            ans = ans * ( row - i);
            ans = ans / i;
            System.out.println(ans);
        }
    }
    public static void main(String[] args) {
        int r = 6;
        int c = 3;
        System.out.println(nCr(r-1,c-1));
//        EntireRow(r);
        for (int i = 1; i <= r; i++) {
            EntireRow(i);
        }
    }
}
