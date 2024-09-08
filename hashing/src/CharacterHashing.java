import java.util.Scanner;

public class CharacterHashing {
    static int f(String str, char n) {
        String newStr = str.toUpperCase();
        int [] arr = new int[26];
        for (int i = 0; i < newStr.length(); i++) {
            arr[newStr.charAt(i) - 'A']++;
        }
        n = Character.toUpperCase(n);
        int index = n - 'A';
        if (index >= 0 && index < arr.length)
            return arr[index];
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the character to find its frequency:");
        char n = in.next().charAt(0);
        String str = "AVISHA";
        System.out.println(f(str, n));
    }
}
