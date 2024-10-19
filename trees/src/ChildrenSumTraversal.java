public class ChildrenSumTraversal {
    public void childrenSum(TreeNode root) {
        if (root == null) return;

        // Initialize child sum to 0
        int childSum = 0;
        if (root.left != null) childSum += root.left.val;
        if (root.right != null) childSum += root.right.val;

        // If child sum is greater than root's value, update root's value
        if (childSum >= root.val) {
            root.val = childSum;
        } else {
            // If root's value is greater, propagate the value down to children
            if (root.left != null) root.left.val = root.val;
            if (root.right != null) root.right.val = root.val;
        }

        // Recur for left and right subtrees
        childrenSum(root.left);
        childrenSum(root.right);

        // After recursion, ensure the parent's value matches the children's sum
        int total = 0;
        if (root.left != null) total += root.left.val;
        if (root.right != null) total += root.right.val;
        if (root.left != null || root.right != null) root.val = total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(30);

        ChildrenSumTraversal solution = new ChildrenSumTraversal();
        solution.childrenSum(root);

        System.out.println("Updated Tree Nodes:");
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
