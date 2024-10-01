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

    void printPreorder(Node node) {
        if (node == null)
            return;

        // Print data of node
        System.out.print(node.data + " ");
        // Recur on left subtree
        printPreorder(node.left);
        // Recur on right subtree
        printPreorder(node.right);
    }

    void printPreorder() {
        printPreorder(root);
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
        tree.printPreorder();
    }
}