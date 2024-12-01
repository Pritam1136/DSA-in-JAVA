package DoublyLinkedList;

public class RemoveGivenNode {
    public static void removeGivenNode(Node temp){
        Node prev = temp.previous;
        Node front = temp.next;
        if (front == null){
            prev.next = null;
            temp.previous = null;
            return;
        }
        prev.next = front;
        front.previous = prev;

        temp.next = temp.previous = null;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,};
        Node head = ConvertARR2DLL.convertArr2Dll(arr);
        removeGivenNode(head.next);
        ConvertARR2DLL.display(head.next);
    }
}
