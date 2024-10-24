package binarySearchTree;

public class LargestBSTInBT {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class BSTInfo {
        boolean isBST;
        int size;
        int minValue;
        int maxValue;

        BSTInfo(boolean isBST, int size, int minValue, int maxValue) {
            this.isBST = isBST;
            this.size = size;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return largestBSTHelper(root).size;
    }

    private BSTInfo largestBSTHelper(TreeNode node) {
        if (node == null) {
            return new BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BSTInfo left = largestBSTHelper(node.left);
        BSTInfo right = largestBSTHelper(node.right);

        if (left.isBST && right.isBST && node.val > left.maxValue && node.val < right.minValue) {
            return new BSTInfo(
                    true,
                    left.size + right.size + 1,
                    Math.min(node.val, left.minValue),
                    Math.max(node.val, right.maxValue)
            );
        }

        return new BSTInfo(false, Math.max(left.size, right.size), 0, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        LargestBSTInBT solution = new LargestBSTInBT();
        System.out.println("Size of the largest BST subtree: " + solution.largestBSTSubtree(root)); // Output should be 3
    }
}
