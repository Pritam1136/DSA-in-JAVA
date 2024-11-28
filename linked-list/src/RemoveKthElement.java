public class RemoveKthElement {
    public static Node removeKthElement(Node head, int pos){
        if (head == null)
            return null;
        if (pos == 1){
            head = head.next;
            return head;
        }
        int counter = 0;
        Node temp = head;
        Node previous = null;
        while(temp != null){
            counter++;
            if (counter == pos){
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
        head = removeKthElement(head, 6);
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
