public class SingleElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
        int low = 1, high = arr.length - 2;

        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        if (arr[0] != arr[1]) {
            System.out.println(arr[0]);
            return;
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println(arr[arr.length - 1]);
            return;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                System.out.println(arr[mid]);
                break; // Exit the loop once the single element is found
            } else if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}
