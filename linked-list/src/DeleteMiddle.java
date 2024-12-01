public class DeleteMiddle {

    // Function to delete the middle node
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }

        Node slow = head;
        Node fast = head;
        Node prev = null; // To keep track of the node before `slow`

        // Use two pointers to find the middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // `slow` points to the middle node, and `prev` points to the node before it
        prev.next = slow.next;

        return head; // Return the updated head
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example list
        Node head = ConvertArr2LL.convert(arr);

        System.out.println("Original List:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("List After Deleting Middle Node:");
        printList(head);
    }
}
