public class FindNumApeearing1 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,6,6};
        int xor = 0;
        for (int j : arr) {
            xor = xor ^ j;
        }
        System.out.println(xor);
    }
}
