public class IsPalindrome {
    static void f(int i, int l, int[] arr) {
        if (i >= l)
            return;
        int temp;
        temp = arr[i];
        arr[i] = arr[l];
        arr[l] = temp;
        f(i+1, l-1, arr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        f(0, arr.length-1, arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
