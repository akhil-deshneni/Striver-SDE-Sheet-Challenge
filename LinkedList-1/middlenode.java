public class middlenode extends reverseNodes {

    public int findLength(Node head){
        int len = 0;
        while(head != null && (len += 1) > 0) head = head.next;
        return len;
    }

    private Node Approach1(Node head){
        int len = findLength(head);
        System.out.println(len);
        int mid = len/2;
        Node curr = head;
        while(mid-- > 0){
            curr = curr.next;
        }
        return curr;
    }

    private Node Approach2(Node head){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node middleNode(Node head) {
        Node ans = null;
        // ans = Approach1(head);    
        ans = Approach2(head);
        return ans;
    }

    public static void main(String[] args) {
        middlenode mn = new middlenode();
        reverseNodes rn = new reverseNodes();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = rn.constructLinkedList(arr);
        Node ans = mn.middleNode(head);
        System.out.println("Middle node is " + ans.data);
    }
}
