import java.util.HashMap;

public class ConstructBinaryTreeFromPrePost {

    private HashMap<Integer, Integer> postOrderIndexMap;  // To store index of elements in postorder
    private int preIndex = 0;  // To keep track of current root in preorder

    public TreeNode constructTree(int[] preorder, int[] postorder) {
        int n = preorder.length;
        postOrderIndexMap = new HashMap<>();
        // Store the index of each element in the postorder traversal for quick lookup
        for (int i = 0; i < n; i++) {
            postOrderIndexMap.put(postorder[i], i);
        }
        // Call the recursive function to build the tree
        return buildTree(preorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int postStart, int postEnd) {
        // Base case: If the start index exceeds the end index, return null (no tree)
        if (postStart > postEnd) {
            return null;
        }

        // The current root node is the current element in preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // If this subtree has only one node, return it
        if (postStart == postEnd) {
            return root;
        }

        // The next element in preorder is the left child if it exists
        int postIndex = postOrderIndexMap.get(preorder[preIndex]);  // Find the index of left child in postorder

        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, postStart, postIndex);
        root.right = buildTree(preorder, postIndex + 1, postEnd - 1);

        return root;
    }

    // Helper function to print in-order traversal (for testing purposes)
    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPrePost solution = new ConstructBinaryTreeFromPrePost();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = solution.constructTree(preorder, postorder);

        // Print the constructed binary tree in in-order traversal
        System.out.println("In-order traversal of the constructed tree:");
        solution.printInOrder(root);  // Expected output: 4 2 5 1 6 3 7
    }
}