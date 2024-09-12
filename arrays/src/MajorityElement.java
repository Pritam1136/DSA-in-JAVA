public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,7,3,3,8,1,1,1,4,1,1,6,6,1,1,1,1};
        int el = 0;
        int count = 0;
        int c= 0;

        for (int j : arr) {
            if (count == 0) {
                count = 1;
                el = j;
            }
            if (j == el) {
                count++;
            } else {
                count--;
            }
        }

//        This step will not be done if a problem states that there always be a majority element.
        for (int j : arr) {
            if (el == j)
                c++;
        }
        if (c >= args.length/2)
            System.out.println("Majority element is = "+el);
        else
            System.out.println("No majority element");
    }
}

// Apply moore,s voting algorithm.