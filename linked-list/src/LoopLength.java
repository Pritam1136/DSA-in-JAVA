public class LoopLength {

    // Function to detect a loop and return its length
    public static int findLoopLength(Node head) {
        if (head == null || head.next == null) {
            return 0; // No loop in an empty or single-node list
        }

        Node slow = head;
        Node fast = head;

        // Detect the loop using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If `slow` and `fast` meet, there is a loop
            if (slow == fast) {
                return countLoopLength(slow);
            }
        }

        return 0; // No loop found
    }

    // Helper function to count the number of nodes in the loop
    private static int countLoopLength(Node loopNode) {
        Node current = loopNode;
        int length = 1;

        // Traverse the loop until we return to the starting node
        while (current.next != loopNode) {
            current = current.next;
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        // Creating a linked list with a cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // Creating a loop

        int loopLength = findLoopLength(head);

        if (loopLength > 0) {
            System.out.println("The linked list contains a loop of length: " + loopLength);
        } else {
            System.out.println("The linked list does not contain a loop.");
        }

        // Creating a linked list without a cycle
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        loopLength = findLoopLength(head2);

        if (loopLength > 0) {
            System.out.println("The linked list contains a loop of length: " + loopLength);
        } else {
            System.out.println("The linked list does not contain a loop.");
        }
    }
}
