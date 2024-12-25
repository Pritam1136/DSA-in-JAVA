public class WrapperExample {
    public static void main(String[] args) {
    Integer a = 10;
    Integer b = 20;

//    final int bonus = 10;
//    bonus = 20;

    swap(a,b);
    System.out.println(a + "," + b);

    final A name = new A("Pritam");
    name.name = "Pritam Roy";

//    when a non-primitive is final, you cannot reassign it.
//    name = new A("Kunal");

        System.out.println(name.name);

        for (int i = 0; i < 100000000; i++) {
            A obj = new A("Other name");
        }
    }
    static void swap(Integer a, Integer b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }
}

class A {
    String name;

    A(String name){
        System.out.println("Object is created");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
// Even though Integer is an object, and we are passing a reference to the method, the change in method will not reflect in the original variable. Integer uses final keyword.
// You can use the final keyword to prevent your content from being modified.
// Even in the Final keyword, you cannot change the value when it is primitive datatype, when it is non-primitive datatype you can change the value.
