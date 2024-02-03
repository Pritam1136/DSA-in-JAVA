public class selectionSort {
    // Return minimum index
    static int minIndex(int[] a, int i, int j)
    {
        if (i == j)
            return i;

        // Find the minimum of remaining elements
        int k = minIndex(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k])? i : k;
    }

    // Recursive selection sort.
    // N is sized of a[] and index
    // is index of a starting element.
    static void recurSelectionSort(int[] a, int n, int index)
    {

        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(a, index, n-1);

        // Swapping when index and minimum index are not the same
        if (k != index){
            // swap
            int temp = a[k];
            a[k] = a[index];
            a[index] = temp;
        }
        // Recursively calling selection sort function
        recurSelectionSort(a, n, index + 1);
    }


    // Driver method
    public static void main(String[] args)
    {
        int[] arr = {3, 1, 5, 2, 7, 0};

        // Calling function
        recurSelectionSort(arr, arr.length, 0);

        //printing a sorted array
        for (int j : arr) System.out.print(j + " ");
    }
}
