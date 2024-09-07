import java.util.Scanner;

public class StringPalindrome {
    static boolean f(int i , String str){
        if (i > str.length()/2)
            return true;
        if (str.charAt(i) != str.charAt(str.length()-i-1))
            return false;
        return  f(i+1, str);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str = in.next();
        System.out.println(f(0,str));
    }
}
