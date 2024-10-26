package prep.google.interview.linkedlists;

public class NodeForSingleLinkedList {

    public int data;
    public NodeForSingleLinkedList next;


public NodeForSingleLinkedList(int data) {
    this.data = data;
    this.next=null;

 }

    public NodeForSingleLinkedList(int data,NodeForSingleLinkedList next) {
        this.data = data;
        this.next=next;

    }
}
