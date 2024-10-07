class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class InOrder {
    Node root;

    void printInorder(Node node) {
        if (node == null)
            return;

        // Recur on left subtree
        printInorder(node.left);
        // Print data of node
        System.out.print(node.data + " ");
        // Recur on right subtree
        printInorder(node.right);
    }

    void printInorder() {
        printInorder(root);
    }

    public static void main(String[] args) {
        InOrder tree = new InOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);

        System.out.println("Preorder traversal:");
        tree.printInorder();
    }
}