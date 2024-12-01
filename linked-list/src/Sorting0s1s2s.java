public class Sorting0s1s2s {
    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head; // No sorting needed for an empty list or a single node
        }

        // Create three test double nodes for 0s, 1s, and 2s
        Node zeroDummy = new Node(-1), oneDummy = new Node(-1), twoDummy = new Node(-1);
        Node zero = zeroDummy, one = oneDummy, two = twoDummy;

        // Traverse and distribute nodes into three lists
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Connect the lists: 0s -> 1s -> 2s
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;

        // Return the head of the new sorted list
        return zeroDummy.next;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 1, 0, 0, 1, 2, 2, 0, 2};
        Node head = ConvertArr2LL.convert(arr);

        System.out.println("Original List:");
        print(head);

        Node sortedHead = sort(head);

        System.out.println("Sorted List (0s, 1s, and 2s):");
        print(sortedHead);
    }
}
