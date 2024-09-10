import java.util.Set;
import java.util.HashSet;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 8, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 8, 6, 7, 8, 9, 13};

        // Create a set to store the union
        Set<Integer> unionSet = new HashSet<>();

        // Add all elements of arr1 to the set
        for (int num : arr1) {
            unionSet.add(num);
        }

        // Add all elements of arr2 to the set
        for (int num : arr2) {
            unionSet.add(num);
        }

        // Print the union
        System.out.println("Union of the two arrays: " + unionSet);
    }
}
