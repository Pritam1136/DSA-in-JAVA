public class Add1toNum {

    // Function to reverse the linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Function to add 1 to the number represented by the linked list
    public static Node addOne(Node head) {
        // Reverse the linked list
        head = reverse(head);

        Node current = head;
        int carry = 1;

        // Traverse the reversed list and add 1
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;
            }
            current = current.next;
        }

        // Reverse the list again to restore the original order
        return reverse(head);
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list representing the number 129
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(9);

        System.out.print("Original number: ");
        printList(head);

        // Add 1 to the number
        head = addOne(head);

        System.out.print("Number after adding 1: ");
        printList(head);
    }
}
