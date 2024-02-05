import java.util.Scanner;

public class removeA {
    static void find(String str, String str1){
        if (str.isEmpty()) {
            System.out.println(str1);
            return;
        }
        char ch = str.charAt(0);
        if (ch == 'a'){
            find(str.substring(1), str1);
        } else {
            find(str.substring(1),str1 + ch);
        }
    }
    static String find1(String str){
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (ch == 'a'){
           return find1(str.substring(1));
        } else {
            return  ch + find1(str.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        find(str, "");
        System.out.println(find1(str));
    }
}
