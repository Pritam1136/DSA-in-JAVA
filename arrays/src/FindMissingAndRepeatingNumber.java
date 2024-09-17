public class FindMissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        int n = arr.length;
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;
        long S = 0, S2 = 0;
        for (int j : arr) {
            S += j;
            S2 += j * j;
        }
        long first = S - SN;
        long second = S2 - S2N;
        second = second / first;
        long x = (first + second) / 2;
        long y = x - first;
        System.out.println("Repeating number: " + x + ", Missing number: " + y);
    }
}
