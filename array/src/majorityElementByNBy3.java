// Extended Boyer moore's voting algorithm
public class majorityElementByNBy3 {
    static void majority(int[] arr){
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (count1 == 0 && arr[i] != el2){
                count1 ++;
                el1 = arr[i];
            }
             else if (count2 == 0 && arr[i] != el1){
                count2 ++;
                el2 = arr[i];
            } else if (el1 == arr[i]) {
                count1 ++;
            } else if (el2 == arr[i]) {
                count2 ++;
            } else {
                 count1 --;
                 count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el1)
                count1 ++;
            if (arr[i] == el2)
                count2 ++;
        }
        int min = (arr.length/ 3) + 1;
        if (count1 >= min)
            System.out.println(el1);
        if (count2 >= min)
            System.out.println(el2);
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,2,2,2};
        majority(arr);
    }
}
