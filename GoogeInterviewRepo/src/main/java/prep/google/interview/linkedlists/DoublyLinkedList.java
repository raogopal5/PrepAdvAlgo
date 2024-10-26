package prep.google.interview.linkedlists;

public class DoublyLinkedList {
    NodeForDoublyLinkedList tail;
    NodeForDoublyLinkedList head;

    public void add(int data){
        NodeForDoublyLinkedList temp = new NodeForDoublyLinkedList(data);
        if(head ==null){
            head =temp;
            tail = temp;
        }else{
           tail.next= temp;
           temp.prev = tail;
           tail = temp;
        }
    }

    public void print(){
        NodeForDoublyLinkedList current =head;
        while (current !=null){
            System.out.println(current.data);
            current =current.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        System.out.println(doublyLinkedList.head.data);
        System.out.println(doublyLinkedList.tail.data);
    }
}
