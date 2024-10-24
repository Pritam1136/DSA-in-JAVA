package binarySearchTree;

public class KthLargestElementInBST {
    public int kthLargest(TreeNode1 root, int k) {
        int[] result = new int[2]; // result[0]: count, result[1]: kth largest value
        findKthLargest(root, k, result);
        return result[1];
    }

    private void findKthLargest(TreeNode1 node, int k, int[] result) {
        if (node == null) return;

        findKthLargest(node.right, k, result); // Reverse in-order traversal

        if (++result[0] == k) {
            result[1] = node.val;
            return;
        }

        findKthLargest(node.left, k, result);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(3);
        root.right = new TreeNode1(6);
        root.left.left = new TreeNode1(2);
        root.left.right = new TreeNode1(4);
        root.left.left.left = new TreeNode1(1);

        KthLargestElementInBST solution = new KthLargestElementInBST();
        int k = 2;
        System.out.println("The " + k + "nd largest element is: " + solution.kthLargest(root, k));  // Output should be 5
    }
}
