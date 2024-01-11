public class findNumberThatAppearOnes {
    public static void Ones(int[] arr){
        int xor = 0;
        for (int j : arr) {
            xor = xor ^ j;
        }
        System.out.println(xor);
    }
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,8,4,4};
        Ones(arr);
    }
}
// TC = O(n)
// SC = O(1)