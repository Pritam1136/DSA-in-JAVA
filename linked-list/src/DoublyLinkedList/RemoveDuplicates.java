package DoublyLinkedList;

public class RemoveDuplicates {

    // Method to remove duplicates from a sorted doubly linked list
    public static void removeDuplicates(Node head) {
        if (head == null) return;

        Node current = head;

        while (current.next != null) {
            // If the current node's data is equal to the next node's data
            if (current.data == current.next.data) {
                // Skip the next node by adjusting the 'next' and 'previous' pointers
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.previous = current; // Set the previous pointer of the new next node
                }
            } else {
                // Move to the next node
                current = current.next;
            }
        }
    }

    // Method to print the doubly linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        // Example usage with duplicates in a sorted DLL
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);

        System.out.println("Original Doubly Linked List:");
        printList(head);

        // Remove duplicates
        removeDuplicates(head);

        System.out.println("Doubly Linked List after removing duplicates:");
        printList(head);
    }
}
