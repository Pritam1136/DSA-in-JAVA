class TreeNode5 {
    int val;
    TreeNode5 left, right;
    TreeNode5(int x) {
        val = x;
    }
}

public class IdenticalTrees {
    public static boolean isIdentical(TreeNode5 root1, TreeNode5 root2) {
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
        TreeNode5 root1 = new TreeNode5(1);
        root1.left = new TreeNode5(2);
        root1.right = new TreeNode5(3);
        root1.left.left = new TreeNode5(4);
        root1.left.right = new TreeNode5(5);

        // Create a second tree
        TreeNode5 root2 = new TreeNode5(1);
        root2.left = new TreeNode5(2);
        root2.right = new TreeNode5(3);
        root2.left.left = new TreeNode5(4);
        root2.left.right = new TreeNode5(5);

        // Check if the trees are identical
        System.out.println(isIdentical(root1, root2) ? "The trees are identical." : "The trees are not identical.");
    }
}
