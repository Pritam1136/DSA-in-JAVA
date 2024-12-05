package DoublyLinkedList;

public class InsertTail {
    public static Node insertTail(Node head, int val) {
        // Create a new node with the value and null pointers
        Node newNode = new Node(val);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            return newNode;
        }

        // Traverse to the last node of the list
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Update the last node's next pointer and the new node's previous pointer
        current.next = newNode;
        newNode.previous = current;

        return head; // The head remains unchanged
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);
        head = insertTail(head, 6);

        // Print the list to verify
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
