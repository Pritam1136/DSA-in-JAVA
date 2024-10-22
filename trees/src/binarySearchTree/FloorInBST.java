package binarySearchTree;

public class FloorInBST {
    static public int floor(Treenode root, int val) {
        int floor = -1;
        while (root != null) {
            if (root.val == val) {
                return root.val;
            } else if (val > root.val) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(10);
        root.left = new Treenode(2);
        root.right = new Treenode(12);
        root.left.left = new Treenode(1);
        root.left.right = new Treenode(5);

        System.out.println(floor(root, 11)); // Output should be 10
        System.out.println(floor(root, 6));  // Output should be 5
        System.out.println(floor(root, 3));  // Output should be 2
    }
}
