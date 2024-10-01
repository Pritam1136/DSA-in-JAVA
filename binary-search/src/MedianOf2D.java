public class MedianOf2D {
    static int func(int[][] mat, int n, int m){
        int low = 0;
        int high = mat.length * mat[0].length - 1;
        int req = (mat.length * mat[0].length)/2;
        while (low <= high){
            int mid =(low + high) / 2;
            int smallerEquals = small(mat, mid);
            if (smallerEquals <= req){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    static int small(int[][] mat, int mid){
    int count = 0;
        for (int i = 0; i < mat[0].length; i++) {

        }
        return mid;
    }
    public static void main(String[] args) {
        int [][] arr = {
                {1,5,7,9,11},
                {2,3,4,5,10},
                {9,10,12,14,16}
        };

    }
}
