import java.util.List;
import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        if (root == null) return wrapList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();

            for (int i = 0; i < levelNum; i++) {
                assert queue.peek() != null;
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                assert queue.peek() != null;
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(Objects.requireNonNull(queue.poll()).val);
            }

            wrapList.add(subList);
        }

        return wrapList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal solution = new LevelOrderTraversal();
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println(result);
    }
}