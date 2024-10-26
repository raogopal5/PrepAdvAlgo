package prep.google.interview.stack;

public class StackUsingArray {

    private static int max = 1000;
    int top = 0;
    int a[] = new int[max];

    public boolean isEmptyStack() {
        return (top < 0);
    }

    public StackUsingArray() {
        top = -1;
    }

    public boolean push(int x) {
        if (top >= max - 1) {
            System.out.println("stack is overflow");
            return false;

        } else {
            a[++top] = x;
            return true;
        }
    }


    public int pop() {
        if (top < 0) {
            System.out.println("stack is underflow");
            return 0;

        } else {
            int x = a[--top] ;
            return x;
        }
    }

    public int peek() {
        if (top < 0) {
            System.out.println("stack is underflow");
            return 0;

        } else {
            int x = a[top] ;
            return x;
        }
    }

    void print(){
        for(int i=top;i>-1;i--){
            System.out.println("stack is "+a[i]);
        }
    }

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray();
        stackUsingArray.push(4);
        stackUsingArray.push(5);
        stackUsingArray.print();
        System.out.println("after pop from stack "+stackUsingArray.pop());
        System.out.println("after peek from stack "+stackUsingArray.peek());

    }

}
