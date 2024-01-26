import java.util.Scanner;

public class bookAllocation {
    static int sumOfArray(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
    static int findMaxInArray(int [] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(j, max);
        }
        return max;
    }
    static int noOfStudents(int[] arr, int pages){
        int stu = 1, noOfPages = 0;
        for (int i = 0; i < arr.length; i++) {
            if (noOfPages + arr[i] <= pages){
                noOfPages += arr[i];
            } else {
                stu ++;
                noOfPages = arr[i];
            }
        }
        return stu;
    }
    static int allocate(int[] arr, int students){
        if (students > arr.length-1)
            return -1;
        int low = findMaxInArray(arr), high = sumOfArray(arr);
        while (low <= high){
            int mid = (low + high) / 2;
            int studNum = noOfStudents(arr, mid);
            if (studNum == students){
                return mid;
            } else if (studNum <= students) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n  = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the no. of students");
        int students = in.nextInt();
        int ans = allocate(arr, students);
        if (ans == -1)
            System.out.println("not possible");
        else
            System.out.println(ans);
    }
}
