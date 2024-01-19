public class maxProductSubarray {
    static void maxProduct(int[] arr){
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix = prefix * arr[i];
            suffix = suffix * arr[arr.length - 1 - i];
            max = Math.max(max , Math.max(prefix , suffix));
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        maxProduct(arr);
    }
}
