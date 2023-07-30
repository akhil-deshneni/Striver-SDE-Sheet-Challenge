import java.util.*;

public class detectCycle extends reverseNodes{

    public Node getEndNode(Node head){
        Node curr = head;
        while(curr.next != null) curr = curr.next;
        return curr;
    }

    public boolean Approach1(Node head){
        Set<Node> lookup = new HashSet<>();
        while(head != null){
            if(lookup.contains(head)) return true;
            lookup.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean Approach2(Node head){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean detectLoop(Node head){
        boolean ans = false;
        // ans = Approach1(head);
        ans = Approach2(head);
        return ans;
    }

    public static void main(String[] args) {
        reverseNodes rn = new reverseNodes();
        detectCycle dc = new detectCycle();
        int[] arr = {1,2,3,4,5,6};
        Node head = rn.constructLinkedList(arr);
        Node end = dc.getEndNode(head);
        end.next = head.next.next;
        boolean ans = dc.detectLoop(head);
        if(ans)
            System.out.println("Linked List has a loop");
        else
            System.out.println("The provided Linked List doesnt contain any loop");
    }
}
