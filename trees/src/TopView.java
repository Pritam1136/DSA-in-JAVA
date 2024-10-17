import java.util.*;


// Class for Binary Tree
public class TopView {

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Method to print the top view of a binary tree
    public void topView(Node root) {
        if (root == null) {
            return;
        }

        Map<Integer, Node> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0)); // start with the root at horizontal distance 0

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node tempNode = temp.node;
            int hd = temp.hd;

            // If no node has been recorded at this horizontal distance, add it
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, tempNode);
            }

            // Move to the left and right children with respective horizontal distances
            if (tempNode.left != null) {
                queue.add(new Pair(tempNode.left, hd - 1));
            }

            if (tempNode.right != null) {
                queue.add(new Pair(tempNode.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Node> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    public static void main(String[] args) {

        // Constructing a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        System.out.println("Top view of the binary tree is:");
        TopView tree = new TopView();
        tree.topView(root);  // Expected Output: 2 1 3 6
    }
}

