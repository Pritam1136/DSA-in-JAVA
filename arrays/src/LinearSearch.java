public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,8,6,7,1};
        int n = 5;
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n){
                j =i;
                break;
            }
        }
        if (j == -1){
            System.out.println("Interger not found");
        }
        else {
            System.out.println("Tnterger found in " + j + " index.");
        }
    }
}
