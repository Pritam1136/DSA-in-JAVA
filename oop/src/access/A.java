package access;

public class A {
    private int num;
    public String name;
    int[] arr;

//    getter function
    public int getNum(){
        return num;
    }

//    setter function
    public void setNum(int num){
        this.num = num;
    }

    public A(int num, String name){
        this.num = num;
        this.name = name;
        this.arr = new int[35];
    }
}
