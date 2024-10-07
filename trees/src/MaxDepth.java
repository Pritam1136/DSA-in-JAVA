import java.util.List;

public class MaxDepth {
public int maxDepth(TreeNode root){
    if (root == null) return 0;
    int lh = maxDepth(root.left);
    int rh = maxDepth(root.right);

    return 1 + Math.max(lh, rh);
}
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.right = new TreeNode(7);

       MaxDepth ob = new MaxDepth();

       int result = ob.maxDepth(root);

        System.out.println(result);
    }
}

// TC: O(n);
// SC: O(n);