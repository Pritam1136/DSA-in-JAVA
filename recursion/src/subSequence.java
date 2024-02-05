public class subSequence {
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
        sub("", "abcd");
        subASCII("", "abcd");
    }
}
