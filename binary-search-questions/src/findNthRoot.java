import java.util.Scanner;

public class findNthRoot {
    static int func(int mid, int n, int m){
        long ans = 1;
        for (int i = 0; i < m; i++) {
            ans = ans * mid;
            if (ans > n)
                return 2;
        }
        if (ans == n)
            return 1;
        return 0;
    }
    static int NthRoot(int n, int m){
        int low = 1, high = n;
        while (low <= high){
            int mid = (low + high)/2;
            int midN = func(mid,n,m);
            if (midN == 1)
                return mid;
            else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = in.nextInt();
        System.out.println("Enter the power");
        int m = in.nextInt();
        if (NthRoot(n,m) == -1){
            System.out.println("Answer not found");
        } else {
            System.out.println(NthRoot(n,m));
        }
    }
}
