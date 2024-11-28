public class InsertHead {
    public static Node insertHead(Node head, int val){
        return new Node(val, head);
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
        Node head = ConvertArr2LL.convert(arr);
        head = insertHead(head, 1);
        System.out.println(head.data);
    }
}
