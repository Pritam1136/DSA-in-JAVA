import java.util.Scanner;

public class majorityElement {
        static public int majority(int[] nums) {
            int res = nums[0];
            int count=1;
            for(int i=1;i<nums.length;i++){
                if(nums[i] == res)
                    count++;
                else{
                    if(count != 0)
                        count--;
                    if(count <= 0){
                        res = nums[i];
                        count++;
                    }
                }
            }
            return res;
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int x = majority(arr);
        System.out.println(x);
    }
}
