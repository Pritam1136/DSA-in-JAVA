package staticExample;

public class InnerClasses {
    static class Test{
        String name;
        public Test(String name){
        this.name = name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Kunal");
        Test b = new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);
    }
}

// static level methods and variable are resolved during compile-time.
// non-static level methods and variables are resolved during run-time.