package DoublyLinkedList;

public class InsertAtPosition {
    public static Node insertAtPosition(Node head, int val, int k) {
        Node newNode = new Node(val);

        // Case 1: Insert at the head
        if (k <= 1) {
            newNode.next = head;
            if (head != null) {
                head.previous = newNode;
            }
            return newNode; // New node becomes the head
        }

        // Traverse to the (L-1)th position or the tail
        Node current = head;
        int position = 1; // Track the current position
        while (current != null && position < k - 1) {
            current = current.next;
            position++;
        }

        // Case 2: Insert at the tail if L is greater than the length of the list
        if (current == null || current.next == null) {
            return InsertTail.insertTail(head, val); // Use the previous insertTail method
        }

        // Case 3: Insert in the middle
        newNode.next = current.next;
        newNode.previous = current;
        if (current.next != null) {
            current.next.previous = newNode;
        }
        current.next = newNode;

        return head; // Head remains unchanged
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);
        head = insertAtPosition(head, 9, 3); // Insert 9 at position 3

        // Traverse and print the list to verify
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
