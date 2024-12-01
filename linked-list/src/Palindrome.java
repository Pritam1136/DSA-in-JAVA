public class Palindrome {

    // Function to check if a linked list is a palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // A single node or empty list is always a palindrome
        }

        // Step 1: Find the middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        Node secondHalf = reverse(slow);

        // Step 3: Compare the two halves
        Node firstHalf = head;
        Node secondHalfCopy = secondHalf; // To restore the list later
        boolean isPalin = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4: Restore the original list (optional)
        reverse(secondHalfCopy);

        return isPalin;
    }

    // Helper function to reverse a linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        Node head = ConvertArr2LL.convert(arr);

        System.out.println("Original List:");
        print(head);

        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
