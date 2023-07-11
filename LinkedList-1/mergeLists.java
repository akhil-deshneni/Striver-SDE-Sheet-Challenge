public class mergeLists extends reverseNodes{

    private Node mergeSortedLists(Node l1,Node l2){
        Node dummy = new Node(-1);
        Node parser = dummy;
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                parser.next = l1;
                l1 = l1.next;
            }else{
                parser.next = l2;
                l2 = l2.next;
            }
            parser = parser.next;
        }
        if(l1 != null) parser.next = l1;
        if(l2 != null) parser.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        reverseNodes rn = new reverseNodes();
        int arr1[] = {3,7,10};
        int arr2[] = {1,4,5,7,8};
        Node list1 = rn.constructLinkedList(arr1);
        Node list2 = rn.constructLinkedList(arr2);
        Node ans = new mergeLists().mergeSortedLists(list1,list2);
        rn.printer(ans);
    }
}
