import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Students pritam = new Students(88, 17, "Pritam Roy");
        Students chandan  = new Students(98, 11, "Chandan Kumar");
        Students def = new Students();
        Students random = new Students(pritam);
        chandan.changeName("Chandan Kar");
        System.out.println(pritam.marks + " , " + pritam.name + " , " + pritam.rno);
        System.out.println(chandan.marks + " , " + chandan.name + " , " + chandan.rno);
        System.out.println(random.marks + " , " + random.name + " , " + random.rno);
        System.out.println(def.marks + " , " + def.name + " , " + def.rno);
    }
}
class Students{
    int marks;
    int rno;
    String name;
    void changeName(String name){
        this.name = name;
    }
    Students(Students others){
        this.marks = others.marks;
        this.rno = others.rno;
        this.name = others.name;
    }
    Students(int marks, int rno, String name){
        this.marks = marks;
        this.rno = rno ;
        this.name = name;
    }
    Students(){
//        this is how you call a constructor from another constructor.
//        internally : new Student()
        this(76,27, "default name" );
    }
}