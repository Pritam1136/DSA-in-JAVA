import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorder {
    private HashMap<Integer, Integer> inorderIndexMap;  // To store indices of inorder elements
    private int postIndex;  // To track the current root in postorder

    public TreeNode constructTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        postIndex = n - 1;  // Start from the last element in postorder (root)
        inorderIndexMap = new HashMap<>();

        // Map each element's index in an inorder array for quick lookup
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Recursively build the tree from postorder and inorder
        return buildTree(postorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] postorder, int inStart, int inEnd) {
        // Base case: If the range is invalid, return null (no subtree)
        if (inStart > inEnd) {
            return null;
        }

        // Get the root value from the postorder traversal
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // If there's only one node, return it (leaf node)
        if (inStart == inEnd) {
            return root;
        }

        // Find the index of the root in the inorder traversal
        int inorderRootIndex = inorderIndexMap.get(rootVal);

        // Recursively build the right subtree first, since postorder goes left -> right -> root
        root.right = buildTree(postorder, inorderRootIndex + 1, inEnd);

        // Recursively build the left subtree
        root.left = buildTree(postorder, inStart, inorderRootIndex - 1);
        return root;
    }

    // Helper function to print pre-order traversal (for testing purposes)
    public void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorder solution = new ConstructBinaryTreeFromInorderAndPostorder();
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = solution.constructTree(inorder, postorder);

        // Print the constructed binary tree in pre-order traversal
        System.out.println("Pre-order traversal of the constructed tree:");
        solution.printPreOrder(root);  // Expected output: 1 2 4 5 3 6 7
    }
}
