import java.util.HashMap;

public class NumberOfSubstringContainingAllThreeCharacter {
    public static int numberOfSubstring(String s) {
        int count = 0; // To track the number of valid substrings
        int l = 0;     // Left pointer of the window
        HashMap<Character, Integer> map = new HashMap<>();
        int r = 0;

        while ( r < s.length()) {
            // Add the character at the right pointer to the map
            char currentChar = s.charAt(r);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // While the map contains all three characters, shrink the window
            while (map.size() == 3) {
                // Count all substrings ending at `r` and starting from `l`
                count += s.length() - r; // All substrings from `l` to the end are valid

                // Remove the leftmost character from the window
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++; // Move the left pointer
            }
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "bbacba";
        System.out.println("Number of substrings containing all three characters: " + numberOfSubstring(s));
    }
}
