class Node2 {
    int data;
    Node2 left, right;

    public Node2(int item) {
        data = item;
        left = right = null;
    }
}

class PostOrder {
    Node2 root;

    void printPostorder(Node2 node) {
        if (node == null)
            return;

        // Recur on left subtree
        printPostorder(node.left);
        // Recur on right subtree
        printPostorder(node.right);
        // Print data of node
        System.out.print(node.data + " ");
    }

    void printPostorder() {
        printPostorder(root);
    }

    public static void main(String[] args) {
        PostOrder tree = new PostOrder();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.left.right = new Node2(5);

        System.out.println("Postorder traversal:");
        tree.printPostorder();
    }
}
