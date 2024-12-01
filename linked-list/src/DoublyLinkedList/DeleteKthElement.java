package DoublyLinkedList;


public class DeleteKthElement {
    public static Node deleteKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }

        Node temp = head;

        int count = 1;
        while (temp != null) {
            if (count == k){
                break;
            }
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid k: exceeds the size of the list.");
            return head;
        }

        Node prev = temp.previous;
        Node next = temp.next;

        // Unlink the k-th node
        if (prev == null && next == null) {
            return null;
        } else if (prev == null){
            return DeleteHead.deleteHead(head);
        } else if (next == null) {
            return DeleteTail.deleteTail(head);
        }

        prev.next = next;
        next.previous = prev;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);

        head = deleteKthElement(head, 4);
        ConvertARR2DLL.display(head);
    }
}
