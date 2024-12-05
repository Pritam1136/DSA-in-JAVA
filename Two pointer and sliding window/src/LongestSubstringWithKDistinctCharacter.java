import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacter {
    public static int longestSubstring(String s, int k) {
        int maxLen = 0; // To track the maximum length
        int l = 0;      // Left pointer of the window
        int r = 0;      // Right pointer of the window
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            // Add the character at the right pointer to the map
            char currentChar = s.charAt(r);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // If the map size exceeds k, shrink the window from the left
            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++; // Move the left pointer
            }

            // Calculate the maximum length of the window
            maxLen = Math.max(maxLen, r - l + 1);

            r++; // Move the right pointer
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabbcd";
        int k = 3;
        System.out.println("Longest substring with " + k + " distinct characters: " + longestSubstring(s, k));
    }
}
