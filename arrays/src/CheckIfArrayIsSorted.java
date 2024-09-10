public class CheckIfArrayIsSorted {
    static boolean check(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] <= arr[i+1]) {

            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,5,4};
        int flag = 0;
        System.out.println(check(arr));
    }
}
