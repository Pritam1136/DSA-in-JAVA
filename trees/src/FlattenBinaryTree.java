public class FlattenBinaryTree {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTree solution = new FlattenBinaryTree();
        solution.flatten(root);

        // Print the flattened tree
        System.out.print("Flattened tree in preorder: ");
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
