public class LemonadeChange {
    public static boolean change(int[] arr) {
        int five = 0, ten = 0;

        for (int bill : arr) {
            if (bill == 5) {
                five++; // Increment count of $5 bills
            } else if (bill == 10) {
                if (five > 0) {
                    five--; // Use one $5 bill as change
                    ten++;  // Increment count of $10 bills
                } else {
                    return false; // Cannot give change
                }
            } else if (bill == 20) {
                // Prefer to use one $10 and one $5 for change
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3; // Use three $5 bills if no $10 is available
                } else {
                    return false; // Cannot give change
                }
            }
        }

        return true; // All customers received correct change
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(change(bills)); // Output: false
    }
}
