import java.util.*;

public class isPalindorme extends reverseNodes{
    
    public boolean Approach1(Node head){
        List<Integer> nodes = new ArrayList<>();
        Node curr = head;
        while(curr != null){
            nodes.add(curr.data);
            curr = curr.next;
        }
        int n = nodes.size()-1;
        int start = 0, end = n;
        while(start < end){
            if(nodes.get(start) != nodes.get(end)) return false;
        }
        return true;
    }

    private Node findMiddle(Node head){
        Node slow = head, fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast.next != null && fast.next.next != null);
        return slow;
    }

    public boolean Approach2(Node head,reverseNodes rn){
        Node getMiddle = findMiddle(head);
        Node reverseNodes = rn.reverseListNodes(getMiddle.next);
        // rn.printer(reverseNodes);
        Node first = head, second = reverseNodes;
        while(second != null){
            if(first.data != second.data) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public boolean checkPalindorme(Node head,reverseNodes rn){
        boolean ans = false;
        // ans =  Approach1(head);
        ans =  Approach2(head,rn);
        return ans;
    }

    public static void main(String[] args) {
        reverseNodes rn = new reverseNodes();
        isPalindorme ip = new isPalindorme();
        int arr[] = {1,2,3,5,3,2,1};
        Node head = rn.constructLinkedList(arr);
        boolean ans = ip.checkPalindorme(head,rn);
        // rn.printer(head);
        if(ans){
            System.out.println("The given linked list is a palindorme ");
        }else{
            System.out.println("The given linked list is not a palindrome");
        }
    }
}
