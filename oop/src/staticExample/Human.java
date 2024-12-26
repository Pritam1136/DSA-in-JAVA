package staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean marraige;
    static int population;

    static void message() {
        System.out.println("Hello world !!!");
    }

    Human(int age, String name, int salary, boolean marraige){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.marraige = marraige;
        this.population += 1;
    }
}
