package DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class FindPairs {

    public static List<List<Integer>> findPairs(Node head, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        Node left = head;
        Node right = head;

        // Move right to the last node
        while (right.next != null) {
            right = right.next;
        }

        // Traverse the list to find pairs with the given sum
        while (left != null && right != null && left != right && left.previous != right) {
            int currentSum = left.data + right.data;

            if (currentSum == sum) {
                // Add the pair to the list
                List<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                list.add(pair);

                // Move both pointers inward
                left = left.next;
                right = right.previous;
            } else if (currentSum > sum) {
                // Move the right pointer backward
                right = right.previous;
            } else {
                // Move the left pointer forward
                left = left.next;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {1, 2, 3, 4, 9};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);

        int targetSum = 5;
        List<List<Integer>> pairs = findPairs(head, targetSum);

        System.out.println("Pairs with sum " + targetSum + ":");
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
