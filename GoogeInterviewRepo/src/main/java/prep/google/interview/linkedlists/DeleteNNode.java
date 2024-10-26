package prep.google.interview.linkedlists;

public class DeleteNNode {

    /**
     * Time Complexity: O(N) since the fast pointer will traverse the entire linked list, where N is the length of the linked list.
     *
     * Space Complexity: O(1), as we have not used any extra space.
     * @param head
     * @param N
     * @return
     */
    // Function to delete the Nth NodeForSingleLinkedList from the end of the linked list
    public static NodeForSingleLinkedList DeleteNthNodeForSingleLinkedListfromEnd(NodeForSingleLinkedList head, int N) {
        // Create two pointers, fastp and slowp
        NodeForSingleLinkedList fastp = head;
        NodeForSingleLinkedList slowp = head;

        // Move the fastp pointer N NodeForSingleLinkedLists ahead
        for (int i = 0; i < N; i++)
            fastp = fastp.next;

        // If fastp becomes null, the Nth NodeForSingleLinkedList from the end is the head
        if (fastp == null)
            return head.next;

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth NodeForSingleLinkedList from the end
        NodeForSingleLinkedList delNodeForSingleLinkedList = slowp.next;
        slowp.next = slowp.next.next;
        delNodeForSingleLinkedList = null;
        return head;
    }

    public static void printLinkedList(NodeForSingleLinkedList head) {
        NodeForSingleLinkedList temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 3;
        NodeForSingleLinkedList head = new NodeForSingleLinkedList(arr[0]);
        head.next = new NodeForSingleLinkedList(arr[1]);
        head.next.next = new NodeForSingleLinkedList(arr[2]);
        head.next.next.next = new NodeForSingleLinkedList(arr[3]);
        head.next.next.next.next = new NodeForSingleLinkedList(arr[4]);

        // Delete the Nth NodeForSingleLinkedList from the end and print the modified linked list
        head = DeleteNthNodeForSingleLinkedListfromEnd(head, N);
        printLinkedList(head);
    }
}
