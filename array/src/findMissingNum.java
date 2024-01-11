public class findMissingNum {
    static void missing(int[] arr){
        int n = arr[arr.length-1];

        int xor1 = 0;
        int xor2 = 0;
//        int sum = (n * (n + 1))/2;
//        int sum2 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum2 += arr[i];
//        }
        for (int i = 0; i < arr.length; i++) {
             xor1 = xor1 ^ arr[i];
             xor2 = xor2 ^ (i + 1);
        }
        xor2 = xor2 ^ n;
        System.out.println(xor1 ^ xor2);
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,6,7};
        missing(arr);
    }
}
