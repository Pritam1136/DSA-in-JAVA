package inheritance;

// Multiple inheritance is not supported in Java
// Hierarchical inheritance is also not allowed.
public class Main {
    public static void main(String[] args) {
//        Box box = new Box();
//        Box box = new Box(4.6,7.5,9.9);
//
//        System.out.println(box.l + ", " + box.b + ", " + box.h);

//        BoxWeight box = new BoxWeight(4.6,7.5,9.9,15);
//        System.out.println(box.h +", " + box.weight);

//         It is the type of reference that determines the properties it can access, not the type of object.
//        Box box5 = new BoxWeight(2,3,4,5);
//        System.out.println(box5.l);

//        BoxWeight box6 = new Box(2,3,4);

        BoxWeight box7  = new BoxWeight(2,3,4,5);
        System.out.println(box7.weight);
    }
}
