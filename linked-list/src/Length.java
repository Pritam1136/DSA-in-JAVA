public class Length {
    public static int length(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            System.out.println(temp.data);
            temp = temp.next;
        }
        return count;
    }
    public static void main(String[] args) {
        int [] arr = {2,5,6,7,3,5};
        Node head = ConvertArr2LL.convert(arr);
        System.out.println(length(head));
    }
}
