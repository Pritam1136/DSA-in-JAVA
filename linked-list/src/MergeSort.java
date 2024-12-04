public class MergeSort {
    // Main function to sort the linked list using merge sort.
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: a list is empty or has one node.
        }

        // Step 1: Split the linked list into two halves.
        Node middle = getMiddle(head);
        Node secondHalf = middle.next;
        middle.next = null; // Break the list into two parts.

        // Step 2: Recursively sort each half.
        Node left = sortList(head);
        Node right = sortList(secondHalf);

        // Step 3: Merge the two sorted halves.
        return merge(left, right);
    }

    // Function to find the middle of the linked list.
    private Node getMiddle(Node head) {
        if (head == null) return null;

        Node slow = head, fast = head.next; // Fast pointer moves twice as fast as slow.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two sorted linked lists.
    private Node merge(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes from either list1 or list2.
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // Helper method to print the linked list.
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the implementation.
    public static void main(String[] args) {
        MergeSort solution = new MergeSort();

        // Create a sample linked list: 4 -> 2 -> 1 -> 3
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original List:");
        printList(head);

        // Sort the list using merge sort.
        Node sortedHead = solution.sortList(head);

        System.out.println("Sorted List:");
        printList(sortedHead);
    }
}
