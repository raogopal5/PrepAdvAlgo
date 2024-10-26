package prep.google.interview.queues;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public QueueUsingStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }


    public void enqueue(int data){

        //move all element from stack 1 to stack 2

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(data);

        //move back all  element from stack 2 to stack 1

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public void deque(int data){
        if(stack1.isEmpty())
        {
            System.exit(0);
        }
        stack1.pop();
    }

    static class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    }

    /* Function to push an item to stack*/
    static void push(Stack<Integer> top_ref, int new_data)
    {
        // Push the data onto the stack
        top_ref.push(new_data);
    }

    /* Function to pop an item from stack*/
    static int pop(Stack<Integer> top_ref)
    {
        /*If stack is empty then error */
        if (top_ref.isEmpty()) {
            return -1;
        }

        // pop the data from the stack
        return top_ref.pop();
    }

    // Function to enqueue an item to the queue
    static void enQueue(Queue q, int x)
    {
        push(q.stack1, x);
    }

    /* Function to deQueue an item from queue */
    static int deQueue(Queue q)
    {
        int x;

        /* If both stacks are empty then error */
        if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
            return -1;
        }

        /* Move elements from stack1 to stack 2 only if
        stack2 is empty */
        if (q.stack2.isEmpty()) {
            while (!q.stack1.isEmpty()) {
                x = pop(q.stack1);
                push(q.stack2, x);
            }
        }
        x = pop(q.stack2);
        return x;
    }

    /* Driver function to test above functions */
    public static void main(String args[])
    {
        /* Create a queue with items 1 2 3*/
        Queue q = new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);

        /* Dequeue items */
        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");
        System.out.println(deQueue(q) + " ");
    }
}
//Push operation: O(1).
//In the worst case we have empty whole of stack 1 into stack 2.
//Pop operation: O(N).
//Same as pop operation in stack.
//Auxiliary Space: O(N).