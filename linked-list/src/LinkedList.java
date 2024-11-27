class Node{
    int data;
    Node next;
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        int [] arr = {2,5,4,7};
        Node y = new Node(3);
        System.out.println(y.data +","+ y.next);
    }
}
