public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int mini = arr[0];
        int profit = 0 , c = 0;
        for (int i=0; i< arr.length; i++) {
            if (arr[i] < mini) {
                mini = arr[i];
                c = i;
            }
        }
        for (int i = c; i < arr.length; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
        }
        System.out.println(profit);
    }
}
