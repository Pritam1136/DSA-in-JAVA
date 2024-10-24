package binarySearchTree;

class TreeNode {
    int val;
    TreeNode1 left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBST {
    public boolean isBST(TreeNode1 root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode1 node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(3);
        root.right = new TreeNode1(7);
        root.left.left = new TreeNode1(2);
        root.left.right = new TreeNode1(4);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(8);

        ValidateBST solution = new ValidateBST();
        System.out.println("Is the tree a BST? " + solution.isBST(root));  // Output should be true
    }
}

