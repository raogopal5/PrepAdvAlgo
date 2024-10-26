package prep.google.interview.queues;

public class QueuseUsingLinkedlist {

    QueueNode front, rear;

    public QueuseUsingLinkedlist() { this.front = this.rear = null; }

    // Method to add an key to the queue.
    void enqueue(int key)
    {

        // Create a new LL node
        QueueNode temp = new QueueNode(key);

        // If queue is empty, then new node is front and
        // rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change
        // rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node
        // ahead
        QueueNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as
        // NULL
        if (this.front == null)
            this.rear = null;
    }

// Driver code

    public static void main(String[] args)
    {
        QueuseUsingLinkedlist q = new QueuseUsingLinkedlist();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front : " + ((q.front != null) ? (q.front).data : -1));
        System.out.println("Queue Rear : " + ((q.rear != null) ? (q.rear).data : -1));
    }
}
