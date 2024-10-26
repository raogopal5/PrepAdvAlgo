package prep.google.interview.linkedlists;

public class ReorderLinkedList {


    NodeForSingleLinkedList middle(NodeForSingleLinkedList head){
        NodeForSingleLinkedList slow = head;
        NodeForSingleLinkedList fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    NodeForSingleLinkedList reverse(NodeForSingleLinkedList head){
        NodeForSingleLinkedList curr = head;
        NodeForSingleLinkedList prev = null;
        NodeForSingleLinkedList forw = null;

        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    /**
     * Time Complexity : O(N) [Middle of List] + O(N/2) [Reversing Second Half] + O(N/2) [Connecting both lists]  = O(2N)  = O(N)
     *
     * Space Complexity : O(1)
     * @param head
     */
    public void reorderList(NodeForSingleLinkedList head) {
        if(head == null || head.next == null)
            return;

        NodeForSingleLinkedList mid = middle(head);
        NodeForSingleLinkedList k = reverse(mid.next);
        mid.next = null;

        NodeForSingleLinkedList c1 = head;
        NodeForSingleLinkedList c2 = k;
        NodeForSingleLinkedList f1 = null;
        NodeForSingleLinkedList f2 = null;

        while(c1 != null && c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }

    public void printLinkedList(NodeForSingleLinkedList head){
        NodeForSingleLinkedList temp = head;
        while (temp !=null){
            System.out.print(temp.data + "");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeForSingleLinkedList head = new NodeForSingleLinkedList(1);
        head.next = new NodeForSingleLinkedList(3);
        head.next.next = new NodeForSingleLinkedList(2);
        head.next.next.next = new NodeForSingleLinkedList(4);
        ReorderLinkedList reorderLinkedList = new ReorderLinkedList();
        reorderLinkedList.reorderList(head);
        reorderLinkedList.printLinkedList(head);
    }

}
