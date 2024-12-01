package DoublyLinkedList;

import java.util.Stack;

public class ReverseADLL {
    public static void reverse(Node head){
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.data = stack.peek();
            stack.pop();
            temp = temp.next;
        }
    }
    public static void print(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);
        reverse(head);
        print(head);
     }
}
