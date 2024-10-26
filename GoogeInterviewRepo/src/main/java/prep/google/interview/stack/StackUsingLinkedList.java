package prep.google.interview.stack;


import static java.lang.System.exit;

//Implementation guide
//Initialise a node
//Update the value of that node by data i.e. node->data = data
//Now link this node to the top of the linked list
//And update top pointer to the current node
public class StackUsingLinkedList {

    NodeForStack top;

    StackUsingLinkedList(){
        this.top = null;
    }



    public  void push(int x){
        NodeForStack temp = new NodeForStack();
        //Initialize the data to temp linked list
        temp.data =x;
        //copy the value to temp linked list
        temp.link = top;
        //switch the temp linked list to top pointer
        top = temp;
        if(top ==null){
            return ;
        }
    }

    public int peek(){

        if(top==null){
            return -1;
        }else {
            return top.data;
        }
    }

    public void pop(){
        if(top==null){
            //update the next pointer references
            top = (top).link;
        }
    }
    public void display() {
        if (top == null) {
            System.out.println("stack underflow");
            exit(1);
        } else {
            NodeForStack temp = top;
            while (temp != null) {
                System.out.println(temp.data);
            }
            temp = temp.link;

            System.out.println("->");
        }
    }
}
