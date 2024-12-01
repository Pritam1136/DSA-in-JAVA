public class DetectLoop {

    // Function to detect a loop in a linked list
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; // No cycle in an empty list or a single-node list
        }

        Node slow = head;
        Node fast = head;

        // Move `fast` two steps and `slow` one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If `slow` and `fast` meet, a loop exists
            if (slow == fast) {
                return true;
            }
        }

        return false; // No cycle detected
    }

    public static void main(String[] args) {
        // Creating a linked list with a cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a cycle

        if (hasCycle(head)) {
            System.out.println("The linked list contains a cycle.");
        } else {
            System.out.println("The linked list does not contain a cycle.");
        }

        // Creating a linked list without a cycle
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        if (hasCycle(head2)) {
            System.out.println("The linked list contains a cycle.");
        } else {
            System.out.println("The linked list does not contain a cycle.");
        }
    }
}
