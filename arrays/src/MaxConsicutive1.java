public class MaxConsicutive1 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,2,1,1,1,0,1,1,1,1,6,1,1,7,1};
        int c = 0, max = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                c++;
               max = Math.max(max, c);
            } else {
                c = 0;
            }
        }
        System.out.println(max);
    }
}
