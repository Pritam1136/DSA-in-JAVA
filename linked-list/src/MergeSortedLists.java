public class MergeSortedLists {

    // Method to merge two sorted linked lists
    public static Node mergeLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Determine the head of the merged list
        Node mergedHead;
        if (l1.data < l2.data) {
            mergedHead = l1;
            l1 = l1.next;
        } else {
            mergedHead = l2;
            l2 = l2.next;
        }

        // Traverse both lists and merge
        Node current = mergedHead;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining part of the non-empty list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return mergedHead;
    }

    // Method to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        Node l1 = ConvertArr2LL.convert(arr1);
        Node l2 = ConvertArr2LL.convert(arr2);

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        Node mergedHead = mergeLists(l1, l2);

        System.out.println("Merged Sorted List:");
        printList(mergedHead);
    }
}
