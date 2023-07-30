import java.util.*;

public class flattenLists {

    // This method uses extra space of O(N) and TC of O(NlogN)
    public Node flatten(Node root){
        PriorityQueue<Node> lowest = new PriorityQueue<>((Node a,Node b)->(
	        Integer.compare(a.data,b.data)
	    ));
	    Node dummy = new Node(-1);
	    Node itr = dummy;
	    while(root != null){
	        lowest.add(root);
	        root = root.next;
	    }
	    while(!lowest.isEmpty()){
	        Node curr = lowest.poll();
	        itr.bottom = curr;
	        if(curr.bottom != null){
	            lowest.add(curr.bottom);
	        }
	        itr = itr.bottom;
	    }
	    return dummy.bottom;
    }

    public Node mergeTwoLists(Node first,Node second){
        Node dummy = new Node(0);
        Node res = dummy;

        while(first != null && second != null){
            if(first.data <= second.data){
                res.bottom = first;
                first = first.bottom;
            }else{
                res.bottom = second;
                second = second.bottom;
            }
            res = res.bottom;
        }

        if(first != null) res.bottom = first;

        if(second != null) res.bottom = second;

        return dummy.bottom;
    }

    public Node recurFlatten(Node head){  
        if(head == null || head.next == null)
            return head;
        head.next = recurFlatten(head.next);
        head = mergeTwoLists(head,head.next);
        return head;
    }

    public Node constructLinkedList(int[] nums){
        Node main = new Node(0);
        Node itr = main;
        for(int num:nums){
            itr.bottom = new Node(num);
            itr = itr.bottom;
        }
        return main.bottom;
    }

    public void printer(Node head){
        while(head != null){
            if(head.bottom != null){
                System.out.print(head.data+"->");
            }else{
                System.out.print(head.data);
            }
            head = head.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        flattenLists ml = new flattenLists();
        int[][] arr = {
            {5,7,8,30},
            {10,20},
            {19,22,50},
            {28,35,40,45}
        };
        List<Node> connector = new ArrayList<>();
        for(int[] node:arr){
            Node curr = ml.constructLinkedList(node);
            connector.add(curr);
        }
        for(int i=0;i<connector.size()-1;i++){
            connector.get(i).next = connector.get(i+1);
        }
    
        Node head = connector.get(0);
        // ml.printer(head);
        // Node ans = ml.flatten(head);
        Node ans = ml.recurFlatten(head);
        ml.printer(ans);
    }    
}


class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}