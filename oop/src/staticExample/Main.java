package staticExample;

public class Main {
    public static void main(String[] args) {
        Human Pritam = new Human(27, "Pritam", 10000, false);
        Human Rahul = new Human(25, "Rahul", 20000, false);
        Human Kunal = new Human(21, "Kunal", 25000, true);

        System.out.println(Pritam.name);
        System.out.println(Human.population + "," + Human.population);
        Human.message();
        fun();
    }
    static void fun(){
        Main obj  = new Main();
        obj.greetings();
    }
//    Something which is non-static belongs to an object.
    void greetings(){
//        fun();
        System.out.println("Hello world !!!");
    }
}

// The static keyword allows you to create class-level members that can be shared, accessed without an object, or used for utility functions.
// Static methods and variables don't belong to an instance, non-static methods and variable do.