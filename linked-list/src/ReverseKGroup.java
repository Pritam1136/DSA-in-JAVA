public class ReverseKGroup {

    // Method to reverse nodes in k-group
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0); // Create a test double node to ease the process
        dummy.next = head;
        Node prevGroupEnd = dummy;

        while (true) {
            // Check if there are at least k nodes remaining
            Node kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) break;

            // Mark the start and end of the group
            Node groupStart = prevGroupEnd.next;
            Node nextGroupStart = kthNode.next;

            // Reverse the group
            reverseGroup(groupStart, kthNode);

            // Connect the reversed group to the previous and next parts of the list
            prevGroupEnd.next = kthNode;
            groupStart.next = nextGroupStart;

            // Update prevGroupEnd for the next group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // Helper method to reverse a group of nodes
    private static void reverseGroup(Node start, Node end) {
        Node prev = null;
        Node current = start;
        Node next = null;
        Node stop = end.next;

        while (current != stop) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    // Helper method to get the k-th node from a given node
    private static Node getKthNode(Node start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
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
        // Example usage
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        Node head = ConvertArr2LL.convert(arr);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("Linked List after reversing in groups of " + k + ":");
        printList(head);
    }
}
