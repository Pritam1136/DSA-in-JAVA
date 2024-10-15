import java.util.*;

class TreeNode1 {
    int val;
    TreeNode1 left, right;
    TreeNode1(int val) {
        this.val = val;
    }
}

public class TraversalsInOne {
    static class NodeState {
        TreeNode1 node;
        int state;

        NodeState(TreeNode1 node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void treeTraversals(TreeNode1 root) {
        if (root == null) return;

        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, 1));

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        while (!stack.isEmpty()) {
            NodeState ns = stack.pop();
            TreeNode1 node = ns.node;
            int state = ns.state;

            if (state == 1) {
                preorder.add(node.val);
                stack.push(new NodeState(node, state + 1));
                if (node.left != null) {
                    stack.push(new NodeState(node.left, 1));
                }
            } else if (state == 2) {
                inorder.add(node.val);
                stack.push(new NodeState(node, state + 1));
                if (node.right != null) {
                    stack.push(new NodeState(node.right, 1));
                }
            } else {
                postorder.add(node.val);
            }
        }

        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(7);

        treeTraversals(root);
    }
}
