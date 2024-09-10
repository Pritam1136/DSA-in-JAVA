public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 4, 5, 7, 8, 9, 13};

        findIntersection(arr1, arr2);
    }

    public static void findIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0;

        System.out.print("Intersection of the two arrays: ");
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }
}
