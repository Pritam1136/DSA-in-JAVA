package binarySearchTree;

public class ConstructBSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int [] index = {0};
        return construct(preorder, 0, preorder.length - 1, index);
    }

    private TreeNode construct(int[] preorder, int min, int max, int[] index) {
        if (index[0] >= preorder.length) return null;

        int val = preorder[index[0]];
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        index[0]++;
        root.left = construct(preorder, min, val, index);
        root.right = construct(preorder, val, max, index);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        ConstructBSTFromPreorder solution = new ConstructBSTFromPreorder();
        TreeNode root = solution.bstFromPreorder(preorder);

        // Print the constructed BST
        System.out.println("Constructed BST from preorder traversal:");
        printInOrder(root);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
