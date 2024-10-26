package prep.google.interview.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private static int currentSize;

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public  void push(int x){
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.remove();
        }
        //swapp
        Queue<Integer> q = q1;
        q1=q2;
        q2=q;
    }

    public int pop(){
        if(q1.isEmpty()){
            return  -1;
        }
        return q1.remove();
    }

    public int size(){
        return q1.size();
    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(5);
        stackUsingQueue.push(6);
        System.out.println("size" + stackUsingQueue.size());
        System.out.println("pop" + stackUsingQueue.pop());
    }

}
