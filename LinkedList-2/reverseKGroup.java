import java.util.*;

class reverseKGroup extends reverseNodes{
    
    public int findLength(Node head){
        Node curr = head;
        int cnt = 0;
        while(curr != null) {
            cnt++;
            curr = curr.next;
        }
        return cnt;
    }

    private Node reverseList(Node head){
        Node next = null, curr = head;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private Node findEndNode(Node head) {
        Node curr = head;
        while(curr.next != null) curr = curr.next;
        return curr;
    }

    public Node Approach1(Node head, int k) {

        int n = findLength(head);
        if(n/k == 0) return head;
        int breaks = n/k;
        Queue<Node> parts = new LinkedList<>();
        Node dummy = new Node(-1);
        dummy.next = head;
        Node iter = dummy;

        for(int i=0;i<breaks;i++) {
            Node curr = iter;
            Node main = iter;
            int chunk = k;
            while(chunk-- > 0) {
                curr = curr.next;
            }
            Node next = curr.next;
            curr.next = null;
            Node rev = reverseList(main.next);
            parts.add(rev);
            dummy.next = next;
            iter = dummy;
        }

        if(iter.next != null) parts.add(iter.next);

        dummy.next = null;
        Node parser = dummy;

        while(!parts.isEmpty()){
            if(parser == dummy){
                parser.next = parts.poll();
            }
            else{
                parser.next = parts.poll();
            }
            parser = findEndNode(parser);
        }
        return dummy.next;
    }

    private Node Approach2(Node head,int k){
        int n = findLength(head);
        return helper(head,k,n/k);
    }

    private Node helper(Node head,int k,int chunks){
        Node curr = head , prev = null, next = null;
        if(chunks > 0){
            int cnt = 0;
            while (cnt < k && curr != null)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt++;
            }
        }
        if(next!=null && chunks > 0)
            head.next = helper(next,k,--chunks);
        return prev == null ? head : prev;
    }

    private Node reverseNodeskGroup(Node head,int k){
        Node ans = null;
        ans = Approach1(head,k);
        ans = Approach2(head,k);
        return ans;
    }

    public static void main(String[] args) {
        reverseKGroup rkg = new reverseKGroup();
        reverseNodes rn = new reverseNodes();
        int[] arr = {1,2,3,4,5};
        Node head = rn.constructLinkedList(arr);
        Node ans = rkg.reverseNodeskGroup(head,3);
        rn.printer(ans);
    }
}