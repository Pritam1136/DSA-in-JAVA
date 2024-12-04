import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Left pointer of the window
        int end = 0;   // Right pointer of the window

        while (end < s.length()) {
            char currentChar = s.charAt(end);

            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                start = map.get(currentChar) + 1;
            }

            map.put(currentChar, end);

            maxLength = Math.max(maxLength, end - start + 1);

            end++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "cadbzabcd";
        System.out.println("Longest substring without repeating characters: " + longestSubstring(s));
    }
}
