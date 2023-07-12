import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

class reverseNodes {

    public Node constructLinkedList(int[] nums){
        Node dummy = new Node(-1);
        Node ptr = dummy;
        for(int num:nums){
            ptr.next = new Node(num);
            ptr = ptr.next;
        }
        return dummy.next;
    }

    private Node Approach1(Node head){
        Stack<Node> nodes = new Stack<>();
        while(head != null){
            nodes.push(head);
            head = head.next;
        }
        Node dummy = new Node(-1);
        Node ptr = dummy;
        while(!nodes.isEmpty()){
            ptr.next = nodes.pop();
            ptr = ptr.next;
        }
        ptr.next = null;
        head = dummy.next;
        return head;
    }

    private Node Approach2(Node head){
        if(head.next == null) return head;
        Node curNode = Approach2(head.next);
        head.next.next = head;
        head.next = null;
        return curNode;
    }

    private Node Approach3(Node head){
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

    public Node reverseListNodes(Node head){
        Node ans = null;
        // ans = Approach1(head);
        // ans = Approach2(head);
        ans = Approach3(head);
        return ans;
    }

    public void printer(Node head){
        while(head != null){
            if(head.next != null){
                System.out.print(head.data+"->");
            }
            else{
                System.out.print(head.data);
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        reverseNodes rev = new reverseNodes();
        int arr[] = {1,2,3,4,5,6,7,8};
        Node head = rev.constructLinkedList(arr);
        Node ans = rev.reverseListNodes(head);
        rev.printer(ans);
    }
}