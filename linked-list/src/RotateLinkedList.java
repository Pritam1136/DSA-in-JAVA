public class RotateLinkedList {

    // Method to rotate the linked list
    public static Node rotate(Node head, int k) {
        if (head == null || head.next == null || k <= 0) return head;

        // Find the length of the list and get the tail
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Link the tail to the head to form a circular list
        current.next = head;

        // Find the new head's position after rotation
        int rotationPoint = length - (k % length);
        Node newTail = head;

        for (int i = 1; i < rotationPoint; i++) {
            newTail = newTail.next;
        }

        // Break the circular list and set the new head
        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Method to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        Node head = ConvertArr2LL.convert(arr);

        System.out.println("Original Linked List:");
        printList(head);

        head = rotate(head, k);

        System.out.println("Rotated Linked List:");
        printList(head);
    }
}
