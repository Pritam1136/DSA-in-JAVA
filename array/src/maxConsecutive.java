public class maxConsecutive {
    static void consecutive(int[] arr){
        int flag = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                flag ++;
                max = Math.max(flag,max);
            } else {
                flag = 0;
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int [] arr = {1,1,1,1,1,1,1,1,0,0,0,1,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,2,1,1,1,1};
        consecutive(arr);
    }
}
