import java.util.*;

public class MinimumTimeTakenToBurnBinaryTree {
    // Helper function to find the time taken to burn the tree and distance to the start node
    private static int burnTree(TreeNode root, TreeNode start, int[] distance, int depth) {
        if (root == null) return 0;

        // If the current node is the starting node, set its distance
        if (root == start) {
            distance[0] = depth;
            return 1;
        }

        // Recur for the left and right subtrees
        int leftTime = burnTree(root.left, start, distance, depth + 1);
        int rightTime = burnTree(root.right, start, distance, depth + 1);

        // If the start node is found in the left subtree
        if (distance[0] != -1 && root.left != null) {
            return Math.max(leftTime, distance[0] - depth + rightTime + 1);
        }

        // If the start node is found in the right subtree
        if (distance[0] != -1 && root.right != null) {
            return Math.max(rightTime, distance[0] - depth + leftTime + 1);
        }

        // Return the maximum of left and right times to burn the subtree
        return Math.max(leftTime, rightTime) + 1;
    }

    public static int minimumTimeTakenToBurn(TreeNode root, TreeNode start) {
        if (root == null) return 0;

        // Array to store the distance from the root to the start node
        int[] distance = {-1};

        return burnTree(root, start, distance, 0) - 1;
    }

    // Test case
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        TreeNode start = root.left.left.left; // Starting node is 4

        System.out.println("Minimum time to burn the binary tree: " + minimumTimeTakenToBurn(root, start));
    }
}
