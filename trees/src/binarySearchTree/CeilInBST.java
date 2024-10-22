package binarySearchTree;

public class CeilInBST {
    static public int ceil(Treenode root, int val){
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
        Treenode root = new Treenode(10);
        root.left = new Treenode(2);
        root.right = new Treenode(12);
        root.left.left = new Treenode(1);
        root.left.right = new Treenode(5);

        System.out.println(ceil(root, 11));
        System.out.println(ceil(root, 6));
        System.out.println(ceil(root, 3));
    }
}