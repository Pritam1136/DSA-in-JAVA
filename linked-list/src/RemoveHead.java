public class RemoveHead {
    public static Node removeHead(Node head){
        if (head == null)
            return null;
        head = head.next;
        return head;
    }
    public static void main(String[] args) {
        int [] arr = {2,3,4,5};
        Node head = ConvertArr2LL.convert(arr);
        System.out.println(removeHead(head).data);
    }
}
