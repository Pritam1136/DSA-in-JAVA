package DoublyLinkedList;

import java.util.Stack;

class NodeDll{
    int data;
    NodeDll next;
    NodeDll prev;

    NodeDll(int data, NodeDll next, NodeDll prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    NodeDll(int data){
        this.data = data;
        prev = null;
        prev = null;
    }
}

public class ReverseADLL {
    public static NodeDll convertToDll(int[] arr){
        NodeDll head = new NodeDll(arr[0]);
        NodeDll mover = head;
        for (int i = 1; i < arr.length; i++) {
            NodeDll temp = new NodeDll(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void print(NodeDll head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static void reverse(NodeDll head){
        NodeDll temp = head;
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
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        NodeDll head = convertToDll(arr);
        reverse(head);
        print(head);
     }
}
