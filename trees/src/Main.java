public class Main {
    int data;
    Main left;
    Main right;
    Main(int key){
        data = key;
    }
    public static void main(String[] args) {
       Main root = new Main(1);
        root.left = new Main(2);
        root.right = new Main(3);
        root.left.right = new Main(5);
    }
}
//Full binary tree - Either has 2 or 0 children.
//Complete binary tree - All levels are filled except the last level.Last level has all nodes as left as possible.
//Perfect binary tree - All leaf node in same level.
//Balance binary tree - Height of the tree at max is log(n).
//Degenerate binary tree - Every node has only one child.
//DFS
//In-order Traversal - Left, Root, Right
//Pre-order Traversal - Root, Left, Right
//Post-order Traversal - Left, Right, Root