package prep.google.interview.linkedlists;

public class SinglyLinkedList {

     NodeForSingleLinkedList head;
    public void printLinkedList() {
        NodeForSingleLinkedList current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
            //System.out.println("->");
        }
    }

    public void add(int data) {
        NodeForSingleLinkedList temp = new NodeForSingleLinkedList(data);
        if (head == null) {
            head = temp;
        } else {
            NodeForSingleLinkedList current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public void addInFirstNode(int data){
        NodeForSingleLinkedList temp = new NodeForSingleLinkedList(data);
        if(head ==null){
            head = temp;
        }else{
            temp.next= head;
            head= temp;
        }
    }

    public void addElementUsingIndex(int index, int data) {
        int count = 0;
        if (index == 0) {
            addInFirstNode(data);
        } else {
            NodeForSingleLinkedList temp = new NodeForSingleLinkedList(data);
            NodeForSingleLinkedList current = this.head;
            while (count < index - 1) {
                    current = current.next;
                count++;
            }
            temp.next = current.next;
            current.next = temp;


        }
    }
    public void removeFirstNode(int data){
        if(head==null){

        }else if(head.next ==null){
            head =null;
        }else if(head.next !=null){
            NodeForSingleLinkedList current =head;
            head = head.next;
            current.next =null;
        }

    }
    public void removeLastNode(int data){
        if(head==null){

        }else if(head.next ==null){
            head =null;
        }else if(head.next !=null){
            NodeForSingleLinkedList current = head;
            while(current.next.next !=null){
                current = current.next;
            }
            current.next =null;
        }
    }

    public int size(){
        NodeForSingleLinkedList current = head;
        int count =0;
        while(current !=null){
            current = current.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(6);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.addInFirstNode(1);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.addElementUsingIndex(2,8);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.removeLastNode(6);
        singlyLinkedList.printLinkedList();
        singlyLinkedList.removeFirstNode(1);
        singlyLinkedList.printLinkedList();
    }
}
