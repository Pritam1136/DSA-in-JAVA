public class RemoveValue {
    public static Node removeValue(Node head, int val){
        if (head == null)
            return null;
        if (head.data == val){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node previous = null;
        while(temp != null){
            if (temp.data == val){
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        Node head = ConvertArr2LL.convert(arr);
        head = removeValue(head, 1);
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
