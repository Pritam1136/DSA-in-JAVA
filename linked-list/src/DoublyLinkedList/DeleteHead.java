package DoublyLinkedList;

public class DeleteHead {
    public static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;

        head = head.next;
        head.previous = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);
        head = deleteHead(head);
        ConvertARR2DLL.display(head);
    }
}
