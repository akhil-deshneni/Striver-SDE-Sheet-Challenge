public class rotateList {

    public int findLength(Node head) {
        int c = 0;
        while(head != null && (c+=1) > 0) head = head.next;
        return c;
    }

    public Node Approach1(Node head,int k){
        /* The time complexity for this is O(k*n) and space is O(1)
         * 
         */
        int count = findLength(head);
        k = k % count;
        while(k-- > 0){
            Node curr = head;
            while(curr.next.next != null) curr = curr.next;
            Node nextNode = curr.next;
            curr.next = null;
            nextNode.next = head;
            head = nextNode;
        }
        return head;
    }

    public Node Approach2(Node head,int k, reverseNodes rn){
        /*
         * The time complexity for this approach is O(N+N) ans space complexity is O(1)
         */
        if(head == null || k == 0) return head;
        int count = findLength(head);
        k = k % count;
        if(k == 0) return head;
        head = rn.reverseListNodes(head);
        Node first = head, second = head;
        Node prev = second;
        while(k-- > 0){
            second = second.next;
            if(k >= 1)
                prev = second;
        }
        prev.next = null;
        second = rn.reverseListNodes(second);
        first = rn.reverseListNodes(first);
        head.next = second;
        head = first;
        return head;
    }

    public Node rotateRight(Node head, int k,reverseNodes rn) {
        Node ans = null;
        // ans = Approach1(head,k);
        ans = Approach2(head,k,rn);
        return ans;
    }

    public static void main(String[] args) {
        rotateList rl = new rotateList();
        reverseNodes rn = new reverseNodes();
        int[] arr = {1,2};
        Node head = rn.constructLinkedList(arr);
        Node ans = rl.rotateRight(head,13,rn);
        rn.printer(ans);
    }   
}
