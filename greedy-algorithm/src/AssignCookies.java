import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // Pointer for greed factors (children)
        int j = 0; // Pointer for cookie sizes

        // Iterate through both arrays
        while (i < g.length && j < s.length) {
            // If the cookie satisfies the child's greed
            if (s[j] >= g[i]) {
                i++; // Move to the next child
            }
            j++; // Move to the next cookie
        }

        // The number of satisfied children
        return i;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s)); // Output: 1
    }
}
