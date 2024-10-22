package binarySearchTree;

public class DeleteANodeInBST {
    public Treenode deleteNode(Treenode root, int key) {
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
            Treenode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private Treenode findMin(Treenode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(10);
        root.left = new Treenode(5);
        root.right = new Treenode(15);
        root.left.left = new Treenode(3);
        root.left.right = new Treenode(7);
        root.right.left = new Treenode(12);
        root.right.right = new Treenode(18);

        DeleteANodeInBST solution = new DeleteANodeInBST();
        System.out.println("BST before deletion:");
        printInOrder(root);

        root = solution.deleteNode(root, 10);
        System.out.println("\nBST after deletion:");
        printInOrder(root);
    }

    public static void printInOrder(Treenode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
