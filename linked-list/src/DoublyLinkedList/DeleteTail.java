package DoublyLinkedList;

public class DeleteTail {

    public static Node deleteTail(Node head) {
        // If the list is empty or has only one node
        if (head == null || head.next == null) {
            System.out.println("The list is empty or has only one node.");
            return null;
        }

        // Traverse to the second-to-last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Remove the tail node
        temp.next = null; // Unlink the tail node

        // Return the updated head
        return head;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; // Example list
        Node head = ConvertARR2DLL.convertArr2Dll(arr); // Convert an array to DLL

        System.out.println("Original List:");
        ConvertARR2DLL.display(head); // Display an original list

        // Remove the tail
        head = deleteTail(head);

        // Check if the list is empty after deletion
        if (head == null) {
            System.out.println("The list is now empty.");
        } else {
            System.out.println("List after deleting the tail:");
            ConvertARR2DLL.display(head); // Display an updated list
        }
    }
}
