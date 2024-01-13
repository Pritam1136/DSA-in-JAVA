// Moore's voting algorithm
public class majorityElement {
    static int majority(int[] arr, int n){
        int count = 0;
        int el = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0){
                count = 1;
                el = arr[i];
            } else if (arr[i] == el) {
                count ++;
            } else {
                count --;
            }
        }
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el){
                 count1 ++;
            }
        }
        if (count1 > n/2)
            return el;
        else
            return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,1,2,2,1};
        int m = majority(arr,arr.length);
        System.out.println("Majority element is : " +m);
    }
}
// TC = O(n) + O(n)
// SC = O(1)