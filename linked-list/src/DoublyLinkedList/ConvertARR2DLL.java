package DoublyLinkedList;

class Node {
    int data;
    Node next;
    Node previous;

    // Constructor with all fields
    Node(int data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    // Constructor with only data
    Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

public class ConvertARR2DLL{
    public static Node convertArr2Dll(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void display(Node head){
        while(head != null){
            System.out.print(head.data + ",");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        Node head = convertArr2Dll(arr);
        display(head);
    }
}
