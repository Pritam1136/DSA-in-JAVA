import java.util.Scanner;

public class permutation {
    static void permu(String q, String p) {
        if (p.isEmpty()){
            System.out.println(q);
            return;
        }
        char ch = p.charAt(0);

        for (int i = 0; i <= q.length(); i++) {
            String f = q.substring(0,i);
            String s = q.substring(i);
            permu(f+ch+s,p.substring(1));
        }
    }
    public static void main(String[] args) {
        permu("", "abc");
    }
}
