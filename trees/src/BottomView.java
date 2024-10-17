import java.util.*;

class BottomView {
    Node root;

    // Class to store a node along with its horizontal distance
    static class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Method to print the bottom view of the binary tree
    public void bottomView(Node root) {
        if (root == null) {
            return;
        }

        Map<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));  // Start with the root node at hd = 0

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node tempNode = temp.node;
            int hd = temp.hd;

            // For the bottom view, we overwrite the value at each horizontal distance
            bottomViewMap.put(hd, tempNode.data);

            // Add the left child with hd - 1
            if (tempNode.left != null) {
                queue.add(new Pair(tempNode.left, hd - 1));
            }

            // Add the right child with hd + 1
            if (tempNode.right != null) {
                queue.add(new Pair(tempNode.right, hd + 1));
            }
        }

        // Print the bottom view from the TreeMap
        for (int value : bottomViewMap.values()) {
            System.out.print(value + " ");
        }
    }

    // Driver method
    public static void main(String[] args) {
        BottomView tree = new BottomView();

        // Constructing a binary tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.right = new Node(7);
        tree.root.right.right.right = new Node(8);

        System.out.println("Bottom view of the binary tree is:");
        tree.bottomView(tree.root);
    }
}

