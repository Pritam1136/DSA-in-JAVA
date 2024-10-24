package binarySearchTree;

public class CeilInBST {
    static public int ceil(TreeNode1 root, int val){
        int ceil = -1;
        while (root != null){
            if (root.val == val){
                return root.val;
            } else if (val > root.val) {
                root = root.right;
            } else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(10);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(12);
        root.left.left = new TreeNode1(1);
        root.left.right = new TreeNode1(5);

        System.out.println(ceil(root, 11));
        System.out.println(ceil(root, 6));
        System.out.println(ceil(root, 3));
    }
}