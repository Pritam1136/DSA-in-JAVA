package binarySearchTree;

public class InsertANodeInBST {
    static public TreeNode1 insert(TreeNode1 root, int val) {
        if (root == null) {
            return new TreeNode1(val);
        }

        TreeNode1 current = root;
        while (true) {
            if (val > current.val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode1(val);
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode1(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(10);
        root.left = new TreeNode1(5);
        root.right = new TreeNode1(15);

        root = insert(root, 12);
        root = insert(root, 3);

        System.out.println("Tree after insertion:");
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
