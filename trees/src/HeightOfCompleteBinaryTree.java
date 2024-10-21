public class HeightOfCompleteBinaryTree {
    // Function to compute the height of the tree
    private static int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left; // Move down the leftmost side
        }
        return height;
    }

    // Function to count the number of nodes in a complete binary tree
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // If left and right subtree heights are the same, the left subtree is a perfect binary tree
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2,leftHeight) + countNodes(root.right); // 2^leftHeight + nodes in right subtree
        } else {
            return (int) Math.pow(2,rightHeight) + countNodes(root.left); // 2^rightHeight + nodes in left subtree
        }
    }

    // Example test case
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println("Number of nodes in the complete binary tree: " + countNodes(root));
    }
}
