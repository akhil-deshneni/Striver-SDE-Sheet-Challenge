public class findIntersection {

    public int findLength(Node head){
        int count = 0;
        Node curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        int lena = findLength(headA);
        int lenb = findLength(headB);
        while(lena > lenb){
            headA = headA.next;
            lena--;
        }
        while(lenb > lena){
            headB = headB.next;
            lenb--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        reverseNodes rn = new reverseNodes();
        findIntersection fis = new findIntersection();
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {1,2,3};
        Node list1 = rn.constructLinkedList(arr1);
        Node list2 = rn.constructLinkedList(arr2);
        list2.next.next = list1.next.next.next;
        Node ans = fis.getIntersectionNode(list1, list2);
        System.out.println("Intersection node is "+ ans.data);
    }
}
