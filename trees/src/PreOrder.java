class Node1 {
    int data;
    Node1 left;
    Node1 right;

    public Node1(int item) {
        data = item;
        left = right = null;
    }
}
class  PreOrder {
    Node1 root;

    void printInorder(Node1 node) {
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
        PreOrder tree = new PreOrder();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);

        System.out.println("Inorder traversal:");
        tree.printInorder();
    }
}


