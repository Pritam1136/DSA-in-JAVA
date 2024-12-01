public class InsertBeforeValue {

    public static Node insertBeforeValue(Node head, int valueBefore, int newValue) {
        // If the list is empty, return the head as-is
        if (head == null) {
            System.out.println("The list is empty.");
            return null;
        }

        // If the value is at the head, insert the new node before the current head
        if (head.data == valueBefore) {
            return new Node(newValue, head);
        }

        // Traverse the list to find the node before the target value
        Node temp = head;
        while (temp.next != null && temp.next.data != valueBefore) {
            temp = temp.next;
        }

        // If we reach the end of the list and do not find the value
        if (temp.next == null) {
            System.out.println("Value " + valueBefore + " not found in the list.");
            return head;
        }

        // Insert the new node before the target value
        Node newNode = new Node(newValue);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = ConvertArr2LL.convert(arr);

        // Insert before a specific value
        head = insertBeforeValue(head, 3, 100);  // Insert 100 before 3
        head = insertBeforeValue(head, 1, 200);  // Insert 200 before 1 (head)
        head = insertBeforeValue(head, 10, 300); // Attempt to insert before non-existent value 10

        // Print the updated list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
