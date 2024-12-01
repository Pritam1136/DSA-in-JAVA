public class ReverseALL {

    // Function to reverse a linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;  // Store the next node
            curr.next = prev;  // Reverse the link
            prev = curr;       // Move prev to the current node
            curr = next;       // Move to the next node
        }

        return prev;  // New head of the reversed list
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

        Node reversedHead = reverse(head);

        System.out.println("Reversed List:");
        print(reversedHead);
    }
}
