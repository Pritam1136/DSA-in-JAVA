public class FindLoopStart {

    // Function to find the starting point of the loop
    public static Node findLoopStart(Node head) {
        if (head == null || head.next == null) {
            return null; // No loop in an empty or single-node list
        }

        Node slow = head;
        Node fast = head;

        // Detect the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // Loop detected
                return getLoopStart(head, slow);
            }
        }

        return null; // No loop found
    }

    // Helper function to find the starting point of the loop
    private static Node getLoopStart(Node head, Node meetingPoint) {
        Node start = head;

        while (start != meetingPoint) {
            start = start.next;
            meetingPoint = meetingPoint.next;
        }

        return start; // Starting node of the loop
    }

    public static void main(String[] args) {
        // Creating a linked list with a cycle
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // Creating a loop

        Node loopStart = findLoopStart(head);

        if (loopStart != null) {
            System.out.println("The loop starts at node with data: " + loopStart.data);
        } else {
            System.out.println("The linked list does not contain a loop.");
        }

        // Creating a linked list without a cycle
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        loopStart = findLoopStart(head2);

        if (loopStart != null) {
            System.out.println("The loop starts at node with data: " + loopStart.data);
        } else {
            System.out.println("The linked list does not contain a loop.");
        }
    }
}
