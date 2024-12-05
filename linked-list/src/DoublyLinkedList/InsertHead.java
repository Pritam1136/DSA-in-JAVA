package DoublyLinkedList;

public class InsertHead {
    public static Node insertHead(Node head, int val) {
        // Create a new node
        Node newHead = new Node(val, head, null);

        // If the list is not empty, update the previous pointer of the old head
        if (head != null) {
            head.previous = newHead;
        }

        return newHead; // The new head of the list
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);
        head = insertHead(head, 1);
        System.out.println(head.data); // Output the data of the new head
    }
}
