public class InsertAtK {
    public static Node insertAtK(Node head, int val, int position) {
        // If the position is invalid
        if (position <= 0) {
            System.out.println("Invalid position");
            return head;
        }

        // If the list is empty
        if (head == null) {
            if (position == 1) {
                return new Node(val);
            } else {
                System.out.println("Position out of bounds");
                return null;
            }
        }

        // Insertion at the start of the list
        if (position == 1) {
            return new Node(val, head);
        }

        // Traversing to find the (position - 1) node
        int currentPosition = 1;
        Node temp = head;
        while (temp != null && currentPosition < position - 1) {
            currentPosition++;
            temp = temp.next;
        }

        // If position is out of bounds
        if (temp == null) {
            System.out.println("Position out of bounds");
            return head;
        }

        // Insert the new node
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = ConvertArr2LL.convert(arr);
        head = insertAtK(head, 100, 1);  // Insert at position 1
        head = insertAtK(head, 200, 8);  // Attempt to insert at an out-of-bounds position

        // Print the list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
    }
}

// Definition of the Node class

