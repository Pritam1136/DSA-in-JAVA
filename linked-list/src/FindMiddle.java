public class FindMiddle {

    // Function to find the middle element of a linked list
    public static Node findMiddle(Node head) {
        if (head == null) {
            return null; // Return null if the list is empty
        }

        Node slow = head;
        Node fast = head;

        // Move `fast` two steps and `slow` one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // `slow` will point to the middle element
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

        Node middle = findMiddle(head);

        if (middle != null) {
            System.out.println("Middle Element: " + middle.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
