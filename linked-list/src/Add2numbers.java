public class Add2numbers {
    public static Node add(Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;
        Node dummy = new Node(-1);
        Node curr = dummy;
        int carry = 0;

        while (t1 != null || t2 != null) {
            int sum = carry;
            if (t1 != null) sum += t1.data;
            if (t2 != null) sum += t2.data;

            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;

            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }

        if (carry != 0) {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }

        return dummy.next;
    }
    public static void print(Node result){
        while (result != null){
            System.out.println(result.data);
            result = result.next;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8,8,9};
        Node head1  = ConvertArr2LL.convert(arr1);
        Node head2 = ConvertArr2LL.convert(arr2);
        Node result = add(head1,head2);
        print(result);
    }
}
