class Student {
    int rollNo;
    String name;
    float marks;

    Student(){
//       This is how you call a constructor from another constructor.
//        Internally: new Student(10, "Random name", 100.0F);
        this(10, "Random name", 100.0F);
    }

    Student(int rollNo, String name, float marks){
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void greeting(){
        System.out.println("Hello my name is " + this.name + "!!!");
    }

    void changeName(String newName){
        this.name = newName;
    }

    Student(Student other){
        this.name = other.name;
        this.marks = other.marks;
        this.rollNo = other.rollNo;
    }
}

public class Main {
    public static void main(String[] args) {
        Student pritam = new Student();
        Student kunal = new Student(12,"kunal",80);
        Student other = new Student(pritam);
        pritam.rollNo = 27;

        pritam.changeName("Pritam Roy");
        kunal.changeName("Kunal Kushwaha");

        System.out.println(pritam.rollNo + " " + pritam.name +" "+ pritam.marks);
        System.out.println(kunal.rollNo + " " + kunal.name + " " + kunal.marks);
        System.out.println(other.rollNo + " " + other.name + " " + other.marks);

        kunal.greeting();
        pritam.greeting();
    }
}

// Class is a template of an object. (Logical construct)
// An object is an instance of class. (Physical reality)
// New keyword is used to create an object. (Dynamic memory allocation)
// (.) Operators link objects with instance variable.
// Student n = new Student() Everything on the left hand side of equals sign happens in Compile time and on the right-hand side happens on run time.
// Constructor defines what happens when you create an object of a class.
// (this) keyword points to the current object.
