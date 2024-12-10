import java.util.HashMap;

public class LongestRepeatingCharacter {
    public static int longestRepeatingCharacterWithKReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int maxLength = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char currentChar = s.charAt(r);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // Update the max frequency of any character in the window
            maxFrequency = Math.max(maxFrequency, map.get(currentChar));

            // Check if the current window is valid
            // Total window size - maxFrequency > k means too many replacements needed
            if ((r - l + 1) - maxFrequency > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }

            // Update the maximum length of a valid window
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(longestRepeatingCharacterWithKReplacement(s, k)); // Output: 4
    }
}
