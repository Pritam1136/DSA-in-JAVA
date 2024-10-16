public class IdenticalTrees {
    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        // If both nodes are null, they're identical
        if (root1 == null && root2 == null) return true;

        // If only one of the nodes is null, they're not identical
        if (root1 == null || root2 == null) return false;

        // Check if the current nodes are identical and their subtrees are identical
        return (root1.val == root2.val) &&
                isIdentical(root1.left, root2.left) &&
                isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        // Create a first tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        // Create a second tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        // Check if the trees are identical
        System.out.println(isIdentical(root1, root2) ? "The trees are identical." : "The trees are not identical.");
    }
}
