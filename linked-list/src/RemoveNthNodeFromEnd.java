public class RemoveNthNodeFromEnd {

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;

        Node dummy = new Node(-1); // Test double node to handle edge cases
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        // Move the fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) return head; // If n is greater than the size of the list
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node
        slow.next = slow.next.next;

        return dummy.next; // Return the updated head
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = ConvertArr2LL.convert(arr);

        System.out.println("Original List:");
        print(head);

        int n = 2; // Remove the 2nd node from the end
        Node updatedHead = removeNthFromEnd(head, n);

        System.out.println("List after removing " + n + "th node from end:");
        print(updatedHead);
    }
}
