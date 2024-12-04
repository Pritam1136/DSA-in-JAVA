import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLL {
    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Use a priority queue to manage the nodes by their values.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));

        // Add the head of each list to the priority queue.
        for (Node list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Create a test double node to act as the head of the merged list.
        Node dummy = new Node(0);
        Node current = dummy;

        // Process the priority queue until it is empty.
        while (!minHeap.isEmpty()) {
            Node smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;

            // If there's a next node in the list, add it to the queue.
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummy.next;
    }

    // Helper method to print a linked list.
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test the implementation.
    public static void main(String[] args) {
        MergeKSortedLL solution = new MergeKSortedLL();

        // Create sample linked lists.
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node l3 = new Node(2);
        l3.next = new Node(6);

        Node[] lists = {l1, l2, l3};

        // Merge all the lists and print the result.
        Node mergedHead = solution.mergeKLists(lists);
        printList(mergedHead);
    }
}
