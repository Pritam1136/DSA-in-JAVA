package binarySearchTree;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode1 root, int k) {
        int[] result = new int[2];
        findKthSmallest(root, k, result);
        return result[1];
    }

    private void findKthSmallest(TreeNode1 node, int k, int[] result) {
        if (node == null) return;

        findKthSmallest(node.left, k, result);

        if (++result[0] == k) {
            result[1] = node.val;
            return;
        }

        findKthSmallest(node.right, k, result);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(3);
        root.right = new TreeNode1(6);
        root.left.left = new TreeNode1(2);
        root.left.right = new TreeNode1(4);
        root.left.left.left = new TreeNode1(1);

        KthSmallestElementInBST solution = new KthSmallestElementInBST();
        int k = 3;
        System.out.println("The " + k + "rd smallest element is: " + solution.kthSmallest(root, k));  // Output should be 3
    }
}
