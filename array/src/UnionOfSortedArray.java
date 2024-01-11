import java.util.ArrayList;
import java.util.Scanner;

public class UnionOfSortedArray {
    static ArrayList<Integer> union(int[] arr1, int[] arr2){
        int n1 = arr1.length ;
        int n2 = arr2.length ;
        int i =  0;
        int j =  0;
        ArrayList<Integer> Union = new ArrayList<>();
        while (i<n1 && j<n2){
            if (arr1[i] <= arr2[j]) {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            }
                else {
                    if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
                        Union.add(arr2[j]);
                    j++;
                }
            }
        while (i < n1) // IF any element left in arr1
        {
            if (Union.get(Union.size()-1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < n2) // If any elements left in arr2
        {
            if (Union.get(Union.size()-1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,3,4,5,9};
        int[] arr2 = {2,2,2,3,4,5,6,7};
        ArrayList<Integer> answer = union(arr1, arr2);
        for (int a: answer) {
            System.out.println(a);
        }
    }
}
// TC = O(n1 + n2)
// SC = O(n1 + n2)