package prep.google.interview.linkedlists;

/**
 * Given two sorted linked lists, merge them to produce a combined sorted linked list. Return the head of the final linked list created.
 */
public class MergeTwoLinkedList {

    /**
     * ime Complexity: O(N1+N2) where N1 is the number of nodes in the first linked list and N1 in the second linked list as
     * we traverse both linked lists in a single pass for merging without any additional loops or nested iterations.
     *
     * Space Complexity : O(1) as no additional data structures or space is allocated for storing data,
     * only a constant space for pointers to maintain for traversing the linked list.
     * Function to merge two sorted linked lists
      */

    static NodeForSingleLinkedList sortTwoLinkedLists(NodeForSingleLinkedList list1, NodeForSingleLinkedList list2) {
        // Create a dummy NodeForSingleLinkedList to serve
        // as the head of the merged list
        NodeForSingleLinkedList dummyNodeForSingleLinkedList = new NodeForSingleLinkedList(-1);
        NodeForSingleLinkedList temp = dummyNodeForSingleLinkedList;

        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and
            // link the smaller NodeForSingleLinkedList to the merged list
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer
            // to the next NodeForSingleLinkedList
            temp = temp.next;
        }

        // If any list still has remaining
        // elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting
        // from the next of the dummy NodeForSingleLinkedList
        return dummyNodeForSingleLinkedList.next;
    }

    // Function to print the linked list
    static void printLinkedList(NodeForSingleLinkedList head) {
        NodeForSingleLinkedList temp = head;
        while (temp != null) {
            // Print the data of the current NodeForSingleLinkedList
            System.out.print(temp.data + " ");
            // Move to the next NodeForSingleLinkedList
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example Linked Lists
        NodeForSingleLinkedList list1 = new NodeForSingleLinkedList(1);
        list1.next = new NodeForSingleLinkedList(3);
        list1.next.next = new NodeForSingleLinkedList(5);

        NodeForSingleLinkedList list2 = new NodeForSingleLinkedList(2);
        list2.next = new NodeForSingleLinkedList(4);
        list2.next.next = new NodeForSingleLinkedList(6);

        System.out.print("First sorted linked list: ");
        printLinkedList(list1);

        System.out.print("Second sorted linked list: ");
        printLinkedList(list2);

        NodeForSingleLinkedList mergedList = sortTwoLinkedLists(list1, list2);

        System.out.print("Merged sorted linked list: ");
        printLinkedList(mergedList);
    }
}
