import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class deepCopy {
    
    public Node copyRandomList(Node head) {

        Map<Node,Node> copy = new HashMap<>();
        Node curr = head;
        Node dummy = new Node(0);
        Node deepCopy = dummy;

        while(curr != null) {
            Node temp = new Node(curr.val);
            deepCopy.next = temp;
            copy.put(curr,temp);
            deepCopy = deepCopy.next;
            curr = curr.next;
        }

        for(Map.Entry<Node,Node> itr:copy.entrySet()){
            Node key = itr.getKey();
            Node value = itr.getValue();
            value.next = copy.get(key.next);
            value.random = copy.get(key.random);
        }

        return dummy.next;
    }

    public Node deepCopyOptmial(Node head){
        if(head == null)
            return head;
        Node curr = head;
        // At first I will take a full copy of the nodes and connect the new copy to the original list
        while(curr != null){
            Node copy = new Node(curr.val);
            Node rest = curr.next;
            curr.next = copy;
            copy.next = rest;
            curr = curr.next.next;
        }
        curr = head;
        // After forming the new LinkedList I will do a copy for the reference pointers by using the old reference pointers
        while(curr != null){
            Node copy = curr.next;
            copy.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }
        Node result = head.next;
        curr = head;
        // At last I will remove the old and new connections and will return the new copied linked list 
        while(curr != null){
            Node rest = curr.next.next;
            curr.next.next = rest != null ? rest.next : null;
            curr.next = rest != null ? rest : null;
            curr = curr.next;
        }
        return result;
    }

    public static void main(String[] args) {
        reverseNodes rn = new reverseNodes();
        deepCopy dc = new deepCopy();
        int[] arr = {1,2,3,4,5,6};
        Node head = rn.constructLinkedList(arr);
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random  = head.next;
        head.next.next.next.random = head.next.next.next.next.next;
        head.next.next.next.next.random = null;
        dc.copyRandomList(head);
    }
}
