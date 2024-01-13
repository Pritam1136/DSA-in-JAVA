import java.util.ArrayList;
import java.util.List;

public class RearrangeBySign {
    static void arrangeWhenPosAndNegIsEqual(int [] arr) {
        int [] answer = new int[arr.length];
        int pos = 0 , neg = 1;
        for (int j : arr) {
            if (j < 0) {
                answer[neg] = j;
                neg = neg + 2;
            } else {
                answer[pos] = j;
                pos = pos + 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(answer[i]);
        }
    }
    static void arrangeWhenPosAndNegIsNotEqual(int [] arr){
        List <Integer> pos = new ArrayList<>();
        List <Integer> neg = new ArrayList<>();
        for (int j : arr) {
            if (j > 0) {
                pos.add(j);
            } else {
                neg.add(j);
            }
        }
        if (pos.size() > neg.size()){
            for (int i = 0; i < neg.size(); i++) {
                arr[2  * i] = pos.get(i);
                arr[(2  * i) + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index ++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2  * i] = pos.get(i);
                arr[(2  * i) + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index ++;
            }
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }
    public static void main(String[] args) {
        int [] arr = {3,1,-2,-5,2,-4};
        int [] arr1 = {-1,2,3,4,-3,1};
        arrangeWhenPosAndNegIsEqual(arr);
        System.out.println("-----------------------------------");
        arrangeWhenPosAndNegIsNotEqual(arr1);
    }
}
