package binarySearchTree;

public class LowestCommonAncestorBST {
    public TreeNode1 lowestCommonAncestor(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
        if (root == null) return null;

        // If both p and q are greater than root, LCA lies in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If both p and q are smaller than root, LCA lies in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If p and q are on either side of root, root is LCA
        return root;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(6);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(8);
        root.left.left = new TreeNode1(0);
        root.left.right = new TreeNode1(4);
        root.left.right.left = new TreeNode1(3);
        root.left.right.right = new TreeNode1(5);
        root.right.left = new TreeNode1(7);
        root.right.right = new TreeNode1(9);

        LowestCommonAncestorBST solution = new LowestCommonAncestorBST();
        TreeNode1 p = root.left; // Node with value 2
        TreeNode1 q = root.left.right; // Node with value 4

        TreeNode1 lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));
    }
}

