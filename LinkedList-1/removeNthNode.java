import java.util.Stack;

public class removeNthNode extends reverseNodes{

    public Node Approach1(Node head,int n){
        Stack<Node> nodes = new Stack<>();
        Node dummy = new Node(-1);
        dummy.next = head;
        Node iter = dummy;
        Node curr = iter;
        while(curr != null){
            nodes.push(curr);
            curr = curr.next;
        }
        while(--n >= 0) nodes.pop();
        if(nodes.isEmpty()) 
            return null;
        Node eject = nodes.pop();
        eject.next = eject.next.next == null ? null : eject.next.next;
        return dummy.next;
    }

    public Node Approach2(Node head, int n){
        int k = n;
        Node fast = head;
        while(k-- > 0) fast = fast.next;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node iter = dummy;
        while(fast != null){
            iter = iter.next;
            fast = fast.next;
        }
        iter.next = iter.next.next;
        return dummy.next;
    }

    public Node removeNthFromEnd(Node head, int n) {
        Node ans = null;
        // ans = Approach1(head,n);
        ans = Approach2(head,n);
        return ans;
    }

    public static void main(String[] args) {
        reverseNodes helper = new reverseNodes();
        removeNthNode rnn = new removeNthNode();
        int[] arr = {1,2};
        Node head = helper.constructLinkedList(arr);
        Node ans =  rnn.removeNthFromEnd(head,2);
        // helper.printer(ans);
    }
}
