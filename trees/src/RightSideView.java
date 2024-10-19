import java.util.*;

public class RightSideView {
    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> rightsideview(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node, 0));
        Map<Integer, Integer> map = new HashMap<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode currNode = pair.node;
            int level = pair.hd;

            // Overwrite the value at the current level
            map.put(level, currNode.val);

//            this is for left view
//            map.putIfAbsent(level, currNode.val);

            if (currNode.left != null) {
                queue.offer(new Pair(currNode.left, level + 1));
            }

            if (currNode.right != null) {
                queue.offer(new Pair(currNode.right, level + 1));
            }
        }

        for (int i = 0; i < map.size(); i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        RightSideView solution = new RightSideView();
        List<Integer> result = solution.rightsideview(root);
        System.out.println(result);
    }
}
