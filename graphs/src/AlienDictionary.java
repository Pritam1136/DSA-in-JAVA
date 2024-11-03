import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int length = Math.min(first.length(), second.length());

            boolean foundDifference = false;
            for (int j = 0; j < length; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && first.length() > second.length()) {
                return ""; // Invalid input
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            order.append(c);

            for (char neighbor : graph.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (order.length() != inDegree.size()) {
            return ""; // Cycle detected, invalid order
        }

        return order.toString();
    }

    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String order = solution.alienOrder(words);
        System.out.println("Alien Dictionary Order: " + order); // Expected output: "wertf"
    }
}
