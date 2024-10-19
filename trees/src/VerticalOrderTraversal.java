import java.util.*;

public class VerticalOrderTraversal {
    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // Pair class to store node and its horizontal distance
    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Method to perform vertical order traversal
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.offer(new Pair(root, 0));  // Start with the root at hd = 0
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // Add node value to the map at the correct horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(node.val);

            // The Process the left child with hd-1
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }
            // Process the right child with hd+1
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }
        return new ArrayList<>(map.values());
    }

    // Main function to run the program
    public static void main(String[] args) {
        VerticalOrderTraversal traversal = new VerticalOrderTraversal();

        // Constructing a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Performing vertical order traversal
        List<List<Integer>> result = traversal.verticalOrder(root);

        // Printing the result
        System.out.println("Vertical Order Traversal:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
