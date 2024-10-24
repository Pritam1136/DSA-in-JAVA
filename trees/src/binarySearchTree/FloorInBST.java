package binarySearchTree;

public class FloorInBST {
    static public int floor(TreeNode1 root, int val) {
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
        TreeNode1 root = new TreeNode1(10);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(12);
        root.left.left = new TreeNode1(1);
        root.left.right = new TreeNode1(5);

        System.out.println(floor(root, 11)); // Output should be 10
        System.out.println(floor(root, 6));  // Output should be 5
        System.out.println(floor(root, 3));  // Output should be 2
    }
}
