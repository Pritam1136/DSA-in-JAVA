public class FlattenLL {

    // Node class definition
    static class Node {
        int data;
        Node next;
        Node child;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    // Method to flatten a multi-level linked list
    public static Node flatten(Node head) {
        if (head == null) return null;

        Node current = head;
        Node tail = head;

        // Traverse to find the tail node
        while (tail.next != null) {
            tail = tail.next;
        }

        // Process each node to merge child lists
        while (current != null) {
            if (current.child != null) {
                // Append a child list to the end of the current list
                tail.next = current.child;

                // Move the tail to the end of the newly appended list
                Node temp = current.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                tail = temp;

                // Clear child pointer
                current.child = null;
            }
            current = current.next;
        }

        return head;
    }

    // Method to print the flattened linked list
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
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.child = new Node(5);
        head.child.next = new Node(6);

        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);

        System.out.println("Original Linked List:");
        printList(head);

        Node flattened = flatten(head);

        System.out.println("Flattened Linked List:");
        printList(flattened);
    }
}
