import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
    static ArrayList<Integer> intersection(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> Intersection = new ArrayList<>();
        while (i < n1 && j < n2){
            if (arr1[i] < arr2[j]){
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            }else {
                Intersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return Intersection;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,3,4,5,9};
        int[] arr2 = {2,2,2,3,3,4,5,6,7};
        ArrayList<Integer> answer = intersection(arr1, arr2);
        for (int a: answer) {
            System.out.println(a);
        }
    }
}
// TC = O(n1 + n2) worse case
// SC = O(1)