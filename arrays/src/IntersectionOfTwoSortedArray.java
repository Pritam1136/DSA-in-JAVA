public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 7, 8, 9, 13};

        findIntersection(arr1, arr2);
    }

    public static void findIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;

        System.out.print("Intersection of the two arrays: ");
        // Use two-pointer technique to find intersection
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++; // Move pointer i if arr1[i] is smaller
            } else if (arr2[j] < arr1[i]) {
                j++; // Move pointer j if arr2[j] is smaller
            } else {
                // If both elements are equal, it's part of the intersection
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }
}
