package binarySearchTree;

public class InorderSuccessor {
    static class Treenode {
        int val;
        Treenode left, right;
        Treenode(int x) {
            val = x;
            left = right = null;
        }
    }

    private static Treenode successor(Treenode root, Treenode target) {
        Treenode successor = null;
        while (root != null) {
            if (target.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(5);
        root.left = new Treenode(3);
        root.right = new Treenode(7);
        root.left.left = new Treenode(2);
        root.left.right = new Treenode(4);
        root.right.left = new Treenode(6);
        root.right.right = new Treenode(8);

        Treenode target = root.right; // Node with value 7
        Treenode succ = successor(root, target);

        if (succ != null) {
            System.out.println("Inorder Successor: " + succ.val); // Expected: 8
        } else {
            System.out.println("No Inorder Successor found.");
        }
    }
}
