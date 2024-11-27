public class Traversal {
    public static void main(String[] args) {
        int [] arr = {2,5,6,7,3,5};
        Node head = ConvertArr2LL.convert(arr);
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
