package binarySearchTree;

class Treenode{
    int val;
    Treenode left;
    Treenode right;
    Treenode(int val){
        this.val = val;
        left = right = null;
    }
}

public class SearchInBST {
    static public Treenode searchBST(Treenode root, int val){
        while (root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(10);
        root.left = new Treenode(2);
        root.right = new Treenode(20);
        System.out.println(searchBST(root, 20).val);
    }
}
