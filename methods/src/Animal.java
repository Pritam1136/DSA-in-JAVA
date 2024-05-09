public class Animal {
   void animalSound(){
      System.out.println("Generic animal sound.");
  }
}

 class Dog extends Animal{
      void animalSound(){
        super.animalSound();
        System.out.println("woo!");
    }

     public static void main(String[] args) {
         Dog ob = new Dog();
         ob.animalSound();
     }
}
