public class middlenode extends reverseNodes {

    public Node middleNode(Node head) {
        Node mid = null;
        return mid;
    }

    public static void main(String[] args) {
        middlenode mn = new middlenode();
        reverseNodes rn = new reverseNodes();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Node head = rn.constructLinkedList(arr);
        Node ans = mn.middleNode(head);
        System.out.println("Middle node is" + ans.data);
    }
}
