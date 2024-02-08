import java.util.ArrayList;

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
    static ArrayList<String> permu1 (String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            list.addAll(permu1(f+ch+s, up.substring(1)));
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(permu1("", "abc"));
        permu("", "abc");
    }
}
