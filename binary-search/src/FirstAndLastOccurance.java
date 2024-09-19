public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,8,10,11,14};
        int first = LowerBoundAndUpperBound.lowerBound(arr, arr.length, 8);
        int last = LowerBoundAndUpperBound.upperBound(arr, arr.length, 8);
        if (first == arr.length || arr[first] != 8)
            System.out.println(-1 +","+ -1);
        else
            System.out.println(first +","+(last-1));
    }
}
