import java.util.*;

public class NodesAtDistanceK {
    // Find nodes at distance K from the target node
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        findDistanceK(root, target, K, result);
        return result;
    }

    // Main recursive function to find distance K nodes
    private int findDistanceK(TreeNode root, TreeNode target, int K, List<Integer> result) {
        if (root == null) return -1;

        // If the target is found, find all nodes at distance K in its subtree
        if (root == target) {
            findSubtreeNodesAtDistanceK(root, K, result);
            return 0;
        }

        // Check distance in left subtree
        int leftDistance = findDistanceK(root.left, target, K, result);
        if (leftDistance != -1) {
            // If we found the target in the left subtree, check the current node and right subtree
            if (leftDistance + 1 == K) {
                result.add(root.val);
            } else {
                findSubtreeNodesAtDistanceK(root.right, K - leftDistance - 2, result);
            }
            return leftDistance + 1; // Return distance from root to target
        }

        // Check distance in right subtree
        int rightDistance = findDistanceK(root.right, target, K, result);
        if (rightDistance != -1) {
            // If we found the target in the right subtree, check the current node and left subtree
            if (rightDistance + 1 == K) {
                result.add(root.val);
            } else {
                findSubtreeNodesAtDistanceK(root.left, K - rightDistance - 2, result);
            }
            return rightDistance + 1; // Return distance from root to target
        }

        return -1; // Target not found in this subtree
    }
    // Helper function to find nodes at distance K in the subtree rooted at node
    private void findSubtreeNodesAtDistanceK(TreeNode node, int K, List<Integer> result) {
        if (node == null || K < 0) return;
        if (K == 0) {
            result.add(node.val);
            return;
        }
        findSubtreeNodesAtDistanceK(node.left, K - 1, result);
        findSubtreeNodesAtDistanceK(node.right, K - 1, result);
    }
    public static void main(String[] args) {
        // Construct a binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        NodesAtDistanceK solution = new NodesAtDistanceK();
        TreeNode target = root.left; // Node with value 5
        int K = 2;

        List<Integer> result = solution.distanceK(root, target, K);
        System.out.println("Nodes at distance " + K + " from target: " + result);
    }
}
