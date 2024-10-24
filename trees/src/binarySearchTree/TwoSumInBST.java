package binarySearchTree;

import java.util.*;

public class TwoSumInBST {
    static class Treenode {
        int val;
        Treenode left, right;
        Treenode(int x) {
            val = x;
        }
    }
    public boolean findTarget(Treenode root, int k) {
        if (root == null) return false;

        Stack<Treenode> leftStack = new Stack<>();
        Stack<Treenode> rightStack = new Stack<>();

        pushLeft(root, leftStack);
        pushRight(root, rightStack);

        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            Treenode left = leftStack.peek();
            Treenode right = rightStack.peek();

            if (left == right) break;

            int sum = left.val + right.val;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                Treenode node = leftStack.pop();
                pushLeft(node.right, leftStack);
            } else {
                Treenode node = rightStack.pop();
                pushRight(node.left, rightStack);
            }
        }
        return false;
    }

    private void pushLeft(Treenode node, Stack<Treenode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void pushRight(Treenode node, Stack<Treenode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    public static void main(String[] args) {
        Treenode root = new Treenode(5);
        root.left = new Treenode(3);
        root.right = new Treenode(6);
        root.left.left = new Treenode(2);
        root.left.right = new Treenode(4);
        root.right.right = new Treenode(7);

        TwoSumInBST solution = new TwoSumInBST();
        int target = 9;
        System.out.println("Two sum in BST: " + solution.findTarget(root, target)); // Output should be true
    }
}

