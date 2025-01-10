package access;

public class Main {
    public static void main(String[] args) {
        A obj = new A(10, "Pritam");
//        obj.num; num is a private variable.
        System.out.println(obj.getNum());
    }
}
