package prep.google.interview.queues;

import java.util.NoSuchElementException;

public class CustomQueue {

    public  QueueNode front;
    public QueueNode rear;

    public  int length;

    public CustomQueue(QueueNode front, QueueNode rear, int length) {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public  int size(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void enqueue(int data){
        QueueNode temp = new QueueNode(data);
        if(isEmpty()){
            front = temp;
        }else{
            rear.next = temp;
        }
        rear =temp;
        length++;

    }

    public void printQueue(){
        if(isEmpty()){
            return;
        }
        QueueNode current = front;
        while(current !=null){
            System.out.println(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int deQueue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return result;
    }

    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue(null,null,5);
        customQueue.enqueue(1);
        customQueue.enqueue(2);
        customQueue.enqueue(3);
        customQueue.enqueue(4);
        customQueue.printQueue();
        customQueue.deQueue();
        customQueue.printQueue();

    }
}
