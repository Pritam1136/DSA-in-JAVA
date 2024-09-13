import java.util.Arrays;

public class RearrangeArrayElementBySign {

    static void WhenNegAndPosAreEqual(int[] arr) {
        int[] ans = new int[arr.length];
        int pos = 0, neg = 1;
        for (int j : arr) {
            if (j > 0 && pos < arr.length) {
                ans[pos] = j;
                pos += 2;
            } else if (j < 0 && neg < arr.length) {
                ans[neg] = j;
                neg += 2;
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4}; // Case with equal positive and negative
        WhenNegAndPosAreEqual(arr); // Equal positives and negatives
    }
}
