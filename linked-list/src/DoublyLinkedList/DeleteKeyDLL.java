package DoublyLinkedList;

public class DeleteKeyDLL {

    // Function to delete all occurrences of a key
    public static Node deleteAllOccurrences(Node head, int key) {
        if (head == null) {
            return null; // Empty list
        }

        Node current = head;

        while (current != null) {
            if (current.data == key) {
                // Update the next pointer of the previous node
                if (current.previous != null) {
                    current.previous.next = current.next;
                } else {
                    head = current.next; // Update head if the first node is deleted
                }

                // Update the prev pointer of the next node
                if (current.next != null) {
                    current.next.previous = current.previous;
                }
            }
            current = current.next; // Move to the next node
        }

        return head; // Return the updated head
    }

    // Function to print the Doubly Linked List
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a sample doubly linked list
        Node head = new Node(10);
        head.next = new Node(2);
        head.next.previous = head;
        head.next.next = new Node(10);
        head.next.next.previous = head.next;
        head.next.next.next = new Node(10);
        head.next.next.next.previous = head.next.next;

        System.out.println("Original DLL:");
        printList(head);

        int key = 10;
        head = deleteAllOccurrences(head, key);

        System.out.println("DLL after deleting all occurrences of key " + key + ":");
        printList(head);
    }
}
