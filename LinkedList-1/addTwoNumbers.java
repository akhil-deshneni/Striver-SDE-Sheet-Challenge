public class addTwoNumbers extends reverseNodes{

    public Node addTwoLists(Node l1, Node l2) {
        Node p1 = l1, p2 = l2;
        Node dummy = new Node(-1);
        Node parse = dummy;
        int rem = 0, div = 0 , sum = 0;
        while(p1 != null && p2 != null){
            sum = p1.data + p2.data + div;
            div = sum/10; rem = sum%10;
            parse.next = new Node(rem);
            p1 = p1.next; p2 = p2.next; parse = parse.next;
        }
        while(p1 != null){
            sum = p1.data + div;
            div = sum/10; rem = sum%10;
            parse.next = new Node(rem);
            p1 = p1.next; parse = parse.next;
        }
        while(p2 != null){
            sum = p2.data + div;
            div = sum/10; rem = sum%10;
            parse.next = new Node(rem);
            p2 = p2.next; parse = parse.next;
        }
        if(div != 0){
            parse.next = new Node(div);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        reverseNodes rn = new reverseNodes();
        addTwoNumbers atn = new addTwoNumbers();
        int arr1[] = {4,5,6,7};
        int arr2[] = {9,8,9};
        Node list1 = rn.constructLinkedList(arr1);
        Node list2 = rn.constructLinkedList(arr2);
        Node ans = atn.addTwoLists(list1, list2);
        rn.printer(ans);
    }
}
