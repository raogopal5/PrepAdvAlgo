package prep.google.interview.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class DetectCycleInLinkedList {

    public static boolean detectLoop(NodeForSingleLinkedList head) {
        // Initialize a pointer 'temp'
        // at the head of the linked list
        NodeForSingleLinkedList temp = head;

        // Create a map to keep track
        // of encountered nodes
        Map<NodeForSingleLinkedList, Integer> nodeMap = new HashMap<>();

        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in
            // the map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node in the map
            nodeMap.put(temp, 1);
            // Move to the next node
            temp = temp.next;
        }

        // Step 3: If the list is successfully
        // traversed without a loop, return false
        return false;
    }

    public static void main(String[] args) {
        // Create a sample linked list
        // with a loop for testing
        NodeForSingleLinkedList head = new NodeForSingleLinkedList(1);
        NodeForSingleLinkedList second = new NodeForSingleLinkedList(2);
        NodeForSingleLinkedList third = new NodeForSingleLinkedList(3);
        NodeForSingleLinkedList fourth = new NodeForSingleLinkedList(4);
        NodeForSingleLinkedList fifth = new NodeForSingleLinkedList(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        // Check if there is a loop
        // in the linked list
        if (detectLoop(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }

        // No need to explicitly free memory
        // in Java; the garbage collector handles it
    }
}
