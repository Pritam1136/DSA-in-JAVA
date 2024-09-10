public class ZeroToEnd {
    public static void main(String[] args) {
        int [] arr = {1,0,5,4,0,7,0,4,0,0,3,3,5,6,0,7,0,0};
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                j = i;
                break;
            }
        }
        for (int i = j+1; i < arr.length; i++) {
            if (arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
//TC: O(n)
//SC: O(1)