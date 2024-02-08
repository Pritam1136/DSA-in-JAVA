import java.lang.reflect.Array;
import java.util.ArrayList;

public class subSequence {
    static ArrayList<String> sub1(String p, String up){
        if (up.isEmpty()){
            ArrayList <String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        list.addAll(sub1(p+ch, up.substring(1)));
        list.addAll(sub1( p, up.substring(1)));
        return list;
    }
    static void sub(String q, String p){
        if (p.isEmpty()){
            System.out.println(q);
            return;
        }

        char ch = p.charAt(0);

        sub(q + ch,p.substring(1));
        sub(q,p.substring(1));
    }
    static void subASCII(String q, String p){
        if (p.isEmpty()){
            System.out.println(q);
            return;
        }

        char ch = p.charAt(0);

        sub(q + ch,p.substring(1));
        sub(q + (ch+0),p.substring(1));
        sub(q,p.substring(1));
    }
    public static void main(String[] args) {
        System.out.println(sub1("", "abc"));
        sub("", "abc");
//        subASCII("", "abcd");
    }
}
