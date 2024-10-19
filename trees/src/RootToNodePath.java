import java.util.*;

public class RootToNodePath {
    public boolean getPath(TreeNode root, int target, List<Integer> path) {
        if (root == null) return false;

        path.add(root.val);

        if (root.val == target) return true;

        if (getPath(root.left, target, path) || getPath(root.right, target, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        RootToNodePath solution = new RootToNodePath();
        List<Integer> path = new ArrayList<>();
        int target = 8;

        if (solution.getPath(root, target, path)) {
            System.out.println("Path to node " + target + ": " + path);
        } else {
            System.out.println("Node " + target + " not found in the tree.");
        }
    }
}

