package binarySearchTree;

public class RecoverBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3]; // Array to store first, second, and prev nodes
        inorderTraversal(root, nodes);

        // Swap values of the first and second nodes
        if (nodes[0] != null && nodes[1] != null) {
            int temp = nodes[0].val;
            nodes[0].val = nodes[1].val;
            nodes[1].val = temp;
        }
    }

    private void inorderTraversal(TreeNode root, TreeNode[] nodes) {
        if (root == null) return;

        inorderTraversal(root.left, nodes);

        if (nodes[2] != null && root.val < nodes[2].val) {
            if (nodes[0] == null) {
                nodes[0] = nodes[2]; // First wrong node
            }
            nodes[1] = root; // Second wrong node
        }

        nodes[2] = root; // Update prev node

        inorderTraversal(root.right, nodes);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        RecoverBST solution = new RecoverBST();
        System.out.println("BST before recovery:");
        printInOrder(root);

        solution.recoverTree(root);

        System.out.println("\nBST after recovery:");
        printInOrder(root);
    }
}
