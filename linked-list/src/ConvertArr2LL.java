public class ConvertArr2LL {
    public static Node convert(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void main(String[] args) {
        int [] arr = {2,5,4,7};
        Node head = convert(arr);
        System.out.println(head.data);
    }
}
