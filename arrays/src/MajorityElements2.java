public class MajorityElements2 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3};

        int el1 = 0, el2 = 0;
        int count1 = 0, count2 = 0;
        int c1= 0, c2 = 0;

        for (int j : arr) {
            if (count1 == 0 && j != el2) {
                count1 = 1;
                el1 = j;
            }
            else if (count2 == 0 && j != el1) {
                count2 = 1;
                el2 = j;
            }
            else if (j == el1) {
                count1++;
            }
            else if (j == el2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

//        This step will not be done if a problem states that there always be a majority element.
        for (int j : arr) {
            if (el1 == j)
                c1++;
        }
        for (int j : arr) {
            if (el2 == j)
                c2++;
        }
        if (c1 >= arr.length/3)
            System.out.println("Majority element is = "+el1);
        else
            System.out.println("No majority element");

        if (c2 >= arr.length/3)
            System.out.println("Majority element is = "+el2);
        else
            System.out.println("No majority element");
    }
}
