public class InsertTail {
    public static Node insertTail(Node head, int val){
        if (head == null){
            return new Node(val, head);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        Node head = ConvertArr2LL.convert(arr);
        head = insertTail(head, 6);
        while (head != null){
            System.out.print(head.data + ",");
            head = head.next;
        }
    }
}
