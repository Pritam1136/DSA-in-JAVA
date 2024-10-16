public class MaxSum {
    public int maxSum(Node5 node, int[] max) {
        if (node == null)
            return 0;

        int leftSum = maxSum(node.left, max);
        int rightSum = maxSum(node.right, max);

        // Update the max value with the current path sum
        max[0] = Math.max(max[0], leftSum + rightSum + node.data);

        // Return the maximum path sum including the current node
        return Math.max(leftSum, rightSum) + node.data;
    }

    public int findMaxSum(Node5 root) {
        int[] max = new int[1]; // Using an array to hold the max value
        maxSum(root, max);
        return max[0];
    }

    public static void main(String[] args) {
        Node5 root = new Node5(-10);
        root.left = new Node5(9);
        root.right = new Node5(20);
        root.right.left = new Node5(15);
        root.right.right = new Node5(7);

        MaxSum ob = new MaxSum();
        System.out.println(ob.findMaxSum(root));
    }
}