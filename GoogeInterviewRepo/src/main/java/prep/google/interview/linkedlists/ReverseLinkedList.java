package prep.google.interview.linkedlists;

import java.util.Stack;

public class ReverseLinkedList {

    // Function to reverse the
    // linked list using a stack

    /**
     * Time Complexity: O(2N) This is because we traverse the linked list twice: once to push the values onto the stack,
     * and once to pop the values and update the linked list. Both traversals take O(N) time, hence time complexity  O(2N) ~ O(N).
     *
     * Space Complexity: O(N) We use a stack to store the values of the linked list, and in the worst case,
     * the stack will have all N values,  ie. storing the complete linked list.
     * @param head
     * @return
     */
    public static NodeForSingleLinkedList reverseLinkedList(NodeForSingleLinkedList head) {
        // Create a temporary pointer to
        // traverse the linked list
        NodeForSingleLinkedList temp = head;

        // Create a stack to temporarily
        //store the data values
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push the values of the
        // linked list onto the stack
        while (temp != null) {
            // Push the current node's
            // data onto the stack
            stack.push(temp.data);
            // Move to the next node
            // in the linked list
            temp = temp.next;
        }
        // Reset the temporary pointer
        // to the head of the linked list
        temp = head;

        // Step 2: Pop values from the stack
        // and update the linked list
        while (temp != null) {
            // Set the current node's data
            // to the value at the top of the stack
            temp.data = stack.pop();
            // Move to the next node
            // in the linked list
            temp = temp.next;
        }
        // Return the new head of
        // the reversed linked list
        return head;
    }

    /**
     * Time Complexity: O(N) The code traverses the entire linked list once, where 'n' is the number of nodes in the list. This traversal has a linear time complexity, O(n).
     *
     * Space Complexity: O(1) The code uses only a constant amount of additional space, regardless of the linked list's length. This is achieved by using three pointers (prev, temp and front) to reverse the
     * list without any significant extra memory usage, resulting in constant space complexity, O(1).
     * @param head
     * @return
     */

    public static NodeForSingleLinkedList ReverseLinkedListUsingStack2(NodeForSingleLinkedList head) {

        // Initialize'temp' at
        // head of linked list
        NodeForSingleLinkedList temp = head;

        // Initialize pointer 'prev' to NULL,
        // representing the previous node
        NodeForSingleLinkedList prev = null;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
   while(temp != null){
            // Store the next node in
            // 'front' to preserve the reference
       NodeForSingleLinkedList front = temp.next;

            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev;

            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;

            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;
        }

        // Return the new head of
        // the reversed linked list
   return prev;

    }


    // Function to print the linked list
    public static void printLinkedList(NodeForSingleLinkedList head) {
        NodeForSingleLinkedList temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        NodeForSingleLinkedList head = new NodeForSingleLinkedList(1);
        head.next = new NodeForSingleLinkedList(3);
        head.next.next = new NodeForSingleLinkedList(2);
        head.next.next.next = new NodeForSingleLinkedList(4);

      /*  // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
*/
        System.out.print("Original Linked List2: ");
        printLinkedList(head);
        System.out.print("Reversed Linked List2: ");
        head= ReverseLinkedListUsingStack2(head);
        printLinkedList(head);
    }
}
