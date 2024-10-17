import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    void addLeftBoundary(TreeNode node, List<Integer> boundary){
        TreeNode current = node.left;
        while (current != null){
            if (!isLeaf(current)){
                boundary.add(current.val);
            }
            if (current.left != null){
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }
    void addLeaves(TreeNode node, List<Integer> boundary){
        if (isLeaf(node))
            boundary.add(node.val);
        if (node.left != null)
            addLeaves(node.left, boundary);
        if (node.right != null)
            addLeaves(node.right, boundary);
    }
    void addRightBoundary(TreeNode node, List<Integer> boundary){
        TreeNode current = node.right;
        while(current != null){
            if (!isLeaf(current))
                boundary.add(current.val);
            if (current.right != null)
                current = current.right;
            else
                current = current.left;
        }
    }
    public List<Integer> boundaryTraversal(TreeNode root){
        List<Integer> boundary = new ArrayList<>();
        if (root == null)
            return boundary;
        if (!isLeaf(root))
            boundary.add(root.val);

        addLeftBoundary(root, boundary);
        addLeaves(root, boundary);
        addRightBoundary(root, boundary);

        return boundary;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BoundaryTraversal ob = new BoundaryTraversal();

        System.out.println(ob.boundaryTraversal(root));
    }
}
