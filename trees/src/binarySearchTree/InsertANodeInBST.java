package binarySearchTree;

public class InsertANodeInBST {
    static public Treenode insert(Treenode root, int val) {
        if (root == null) {
            return new Treenode(val);
        }

        Treenode current = root;
        while (true) {
            if (val > current.val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Treenode(val);
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Treenode(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(10);
        root.left = new Treenode(5);
        root.right = new Treenode(15);

        root = insert(root, 12);
        root = insert(root, 3);

        System.out.println("Tree after insertion:");
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
