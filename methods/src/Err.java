import java.util.Scanner;

public class Err {
    public static void main(String[] args) {
        System.out.println("Enter the age ...............");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        try {
            checkAge(age);
            System.out.println("You can watch the movie.");
        }
        catch (AgeException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void checkAge(int age) throws AgeException {
        if (age < 18){
            throw  new AgeException("You are too young...........");
        }
    }
}

class AgeException extends Exception{
    public AgeException(String message){
        super(message);
    }
}