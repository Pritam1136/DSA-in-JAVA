public class Main {
    public static void main(String[] args) {
       int [] arr = {3,4,6,7,9,12,16,17};
        int low = 0,high = arr.length - 1;
       int n = 17;
       while (low <= high){
           int mid = (low + (high - low)) / 2;
           if (arr[mid] == n){
               System.out.println("number found");
               break;
           }
           else if (arr[mid] < n){
               low = mid + 1;
           }
           else {
               high = mid - 1;
           }
       }
    }
}
//TC: O(log(base 2)(n))
//SC: O(1)