public class medianOfTwoSortedArray {
    static double findMedian(int[] arr1, int[] arr2){
        int n1 = arr1.length , n2 = arr2.length;
        int i =0, j = 0;
        int n = n1 + n2;
        int ind2 = n/2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int indel1 = -1, indei2 = -1;
        while (i < n1 && j < n2){
            if (arr1[i] < arr2[j]){
                if (cnt == ind1) indel1 = arr1[i];
                if (cnt == ind2) indei2 = arr1[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1) indel1 = arr2[j];
                if (cnt == ind2) indei2 = arr2[j];
                cnt++;
                j++;
            }
        }
        while (i < n1){
            if (cnt == ind1) indel1 = arr1[i];
            if (cnt == ind2) indei2 = arr1[i];
            cnt++;
            i++;
        }
        while (j < n2){
            if (cnt == ind1) indel1 = arr2[j];
            if (cnt == ind2) indei2 = arr2[j];
            cnt++;
            j++;
        }
        if (n%2 == 1)
            return indei2;
        return (double) ((double)(indel1 + indei2)) / 2.0;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2,3,6,15};
        System.out.println(findMedian(arr1, arr2));
    }
}
