public class Diameter {
    public int diameter(Node5 root){
        int [] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }
    private int height(Node5 root, int[] diameter){
        if (root == null)
            return 0;
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1+ Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node5 root = new Node5(1);
        root.left = new Node5(2);
        root.right = new Node5(3);
        root.right.left = new Node5(4);
        root.right.right = new Node5(5);
        root.right.right.left = new Node5(6);
        Diameter ob = new Diameter();
        int res = ob.diameter(root);
        System.out.println(res);
    }
}
