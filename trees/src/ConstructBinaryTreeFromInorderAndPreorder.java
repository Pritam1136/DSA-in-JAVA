import java.util.HashMap;
public class ConstructBinaryTreeFromInorderAndPreorder {
    private HashMap<Integer, Integer> inorderIndexMap;  // For quick lookup of indices in inorder
    private int preIndex = 0;  // To keep track of the root in preorder traversal

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store the index of each element in the inorder traversal
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // Start building the tree
        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int inStart, int inEnd) {
        // Base case: If there are no elements to construct the subtree
        if (inStart > inEnd) {
            return null;
        }

        // Get the root value from preorder traversal
        int rootVal = preorder[preIndex++];
        // Create the root node
        TreeNode root = new TreeNode(rootVal);

        // Get the index of this root in inorder traversal
        int inorderIndex = inorderIndexMap.get(rootVal);

        // Recursively build the left subtree
        root.left = constructTree(preorder, inStart, inorderIndex - 1);
        // Recursively build the right subtree
        root.right = constructTree(preorder, inorderIndex + 1, inEnd);

        return root;
    }

    // Helper function to print the tree in inorder (for testing purposes)
    public void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPreorder solution = new ConstructBinaryTreeFromInorderAndPreorder();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);

        // Print the constructed binary tree in inorder traversal
        System.out.println("In-order traversal of the constructed tree:");
        solution.printInOrder(root);  // Output: 9 3 15 20 7
    }
}
