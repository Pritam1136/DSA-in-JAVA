package binarySearchTree;

import java.util.Stack;

class TreeNode1 {
    int val;
    TreeNode1 left, right;
    TreeNode1(int x) {
        val = x;
    }
}

public class BSTIterator {

    private Stack<TreeNode1> initializeStack(TreeNode1 root) {
        Stack<TreeNode1> stack = new Stack<>();
        pushAllLeft(root, stack);
        return stack;
    }

    private void pushAllLeft(TreeNode1 node, Stack<TreeNode1> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext(Stack<TreeNode1> stack) {
        return !stack.isEmpty();
    }

    public int next(Stack<TreeNode1> stack) {
        TreeNode1 node = stack.pop();
        int result = node.val;
        pushAllLeft(node.right, stack);
        return result;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(7);
        root.left = new TreeNode1(3);
        root.right = new TreeNode1(15);
        root.right.left = new TreeNode1(9);
        root.right.right = new TreeNode1(20);

        BSTIterator iterator = new BSTIterator();
        Stack<TreeNode1> stack = iterator.initializeStack(root);

        System.out.println(iterator.next(stack));    // Output: 3
        System.out.println(iterator.next(stack));    // Output: 7
        System.out.println(iterator.hasNext(stack)); // Output: true
        System.out.println(iterator.next(stack));    // Output: 9
        System.out.println(iterator.hasNext(stack)); // Output: true
        System.out.println(iterator.next(stack));    // Output: 15
        System.out.println(iterator.hasNext(stack)); // Output: true
        System.out.println(iterator.next(stack));    // Output: 20
        System.out.println(iterator.hasNext(stack)); // Output: false
    }
}
