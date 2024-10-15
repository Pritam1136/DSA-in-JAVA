class Node5{
    int data;
    Node5 left, right;
    public Node5(int data){
        this.data = data;
        left = right = null;
    }
}
public class IsBalance {
    public int isbalance(Node5 root){
        if (root == null)
            return 0;
        int lh = isbalance(root.left);
        if (lh == -1)
            return -1;
        int rh = isbalance(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return Math.max(lh , rh) + 1;
    }

    public static void main(String[] args) {
        Node5 root = new Node5(1);
        root.left = new Node5(2);
        root.right = new Node5(3);
        root.right.left = new Node5(4);
        root.right.right = new Node5(5);
        IsBalance ob = new IsBalance();
        int res = ob.isbalance(root);
        System.out.println(res);
    }
}
