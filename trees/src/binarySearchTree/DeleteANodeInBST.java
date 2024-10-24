package binarySearchTree;

public class DeleteANodeInBST {
    public TreeNode1 deleteNode(TreeNode1 root, int key) {
        if (root == null) return null;

        // Navigate to the node to be deleted
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            TreeNode1 minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode1 findMin(TreeNode1 root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(10);
        root.left = new TreeNode1(5);
        root.right = new TreeNode1(15);
        root.left.left = new TreeNode1(3);
        root.left.right = new TreeNode1(7);
        root.right.left = new TreeNode1(12);
        root.right.right = new TreeNode1(18);

        DeleteANodeInBST solution = new DeleteANodeInBST();
        System.out.println("BST before deletion:");
        printInOrder(root);

        root = solution.deleteNode(root, 10);
        System.out.println("\nBST after deletion:");
        printInOrder(root);
    }

    public static void printInOrder(TreeNode1 root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
