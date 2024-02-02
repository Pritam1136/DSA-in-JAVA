import java.util.ArrayList;
import java.util.Scanner;

public class linearSearch {
    static boolean Search(int[] arr, int n, int target){
        if (n >= arr.length)
            return false;
        if (arr[n] == target)
            return true;
        else
            return Search(arr, ++n, target);
    }
    static ArrayList SearchD (int [] arr, int n , int target, ArrayList<Integer> list){
        if (n >= arr.length)
            return list;
        else if (arr[n] == target)
            list.add(n);
        return SearchD(arr, ++n, target, list);
    }
    static ArrayList SearchD2 (int [] arr, int n , int target){
        ArrayList<Integer> ans = new ArrayList<>();
        if (n >= arr.length)
            return ans;
        else if (arr[n] == target)
            ans.add(n);
        ArrayList<Integer> ansFromBelow =  SearchD2(arr, ++n, target);
        ans.addAll(ansFromBelow);
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array :");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter array elements :");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the target");
        int target = in.nextInt();
        System.out.println(Search(arr,0, target));
        System.out.println(SearchD(arr, 0 , target, new ArrayList<>()));
        System.out.println(SearchD2(arr, 0, target));
    }
}