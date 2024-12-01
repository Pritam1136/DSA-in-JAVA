public class IntersectionPoint {

    // Function to find the intersection point of two linked lists
    public static Node getIntersectionNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null; // No intersection if either list is null
        }

        Node ptr1 = head1;
        Node ptr2 = head2;

        // Traverse both lists; when one reaches the end, switch to the other list
        while (ptr1 != ptr2) {
            ptr1 = (ptr1 == null) ? head2 : ptr1.next;
            ptr2 = (ptr2 == null) ? head1 : ptr2.next;
        }

        // Either the intersection node or null if no intersection
        return ptr1;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create two intersecting linked lists
        Node common = new Node(8);
        common.next = new Node(10);

        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = common;

        Node head2 = new Node(4);
        head2.next = common;

        System.out.println("List 1:");
        print(head1);

        System.out.println("List 2:");
        print(head2);

        Node intersection = getIntersectionNode(head1, head2);
        if (intersection != null) {
            System.out.println("Intersection Point: " + intersection.data);
        } else {
            System.out.println("No intersection point found.");
        }
    }
}
