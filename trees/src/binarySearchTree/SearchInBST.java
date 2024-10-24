package binarySearchTree;

public class SearchInBST {
    static public TreeNode1 searchBST(TreeNode1 root, int val){
        while (root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(10);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(20);
        System.out.println(searchBST(root, 20).val);
    }
}
