import java.util.*;

public class NodesAtDistanceK {

    // TreeNode definition
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Find nodes at distance K from the target node
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        findDistanceK(root, target, K, result);
        return result;
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

    // Returns the distance from root to the target node, -1 if target is not in the subtree
    private int findDistanceK(TreeNode root, TreeNode target, int K, List<Integer> result) {
        if (root == null) return -1;

        // Case 1: If the target node is found
        if (root == target) {
            findSubtreeNodesAtDistanceK(root, K, result); // Find nodes in its subtree
            return 0;
        }

        // Case 2: Check if target is in the left subtree
        int leftDistance = findDistanceK(root.left, target, K, result);
        if (leftDistance != -1) {
            if (leftDistance + 1 == K) {
                result.add(root.val);  // Add the current root if it is at the required distance
            } else {
                findSubtreeNodesAtDistanceK(root.right, K - leftDistance - 2, result);  // Find nodes in the right subtree
            }
            return leftDistance + 1;
        }

        // Case 3: Check if target is in the right subtree
        int rightDistance = findDistanceK(root.right, target, K, result);
        if (rightDistance != -1) {
            if (rightDistance + 1 == K) {
                result.add(root.val);  // Add the current root if it is at the required distance
            } else {
                findSubtreeNodesAtDistanceK(root.left, K - rightDistance - 2, result);  // Find nodes in the left subtree
            }
            return rightDistance + 1;
        }

        return -1;  // Target is not in this subtree
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
        TreeNode target = root.left;  // Node with value 5
        int K = 2;

        List<Integer> result = solution.distanceK(root, target, K);
        System.out.println("Nodes at distance " + K + " from target: " + result);
    }
}

