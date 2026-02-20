package Medium.Stack;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackImplUsingQueues {
//    Implement a last-in-first-out (LIFO) stack using only two queues. T
//    he implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
//
//    Implement the MyStack class:
//
//    void push(int x) Pushes element x to the top of the stack.
//    int pop() Removes the element on the top of the stack and returns it.
//    int top() Returns the element on the top of the stack.
//    boolean empty() Returns true if the stack is empty, false otherwise

      Queue<Integer> mainqueue;
    private Queue<Integer> tempqueue;

    public StackImplUsingQueues(){
        mainqueue = new LinkedList();
        tempqueue = new LinkedList();
    }


//    Queue mainqueue = new PriorityQueue();
//    Queue tempqueue = new PriorityQueue();


    public void push(int x) {
      mainqueue.add(x);
    }

    public int pop() {
     int size = mainqueue.size();
     for(int i = 0; i< size -1; i++){
         tempqueue.add(mainqueue.poll());

     }
     int topelement = mainqueue.poll();
     Queue<Integer> temp = mainqueue;
     mainqueue = tempqueue;
     tempqueue = temp;
     return topelement;
    }

    public int top() {
        int size = mainqueue.size();
        for (int i = 0; i < size - 1; i++) {
            tempqueue.add(mainqueue.poll());
        }
        int topElement = mainqueue.peek(); // peek, not remove
        tempqueue.add(mainqueue.poll());   // move the last element to tempqueue
        // swap queues
        Queue<Integer> temp = mainqueue;
        mainqueue = tempqueue;
        tempqueue = temp;
        return topElement;
    }

    @Override
    public String toString() {
        return "StackImplUsingQueues{" +
                "mainqueue=" + mainqueue +
                ", tempqueue=" + tempqueue +
                '}';
    }

    public boolean empty() {
       return mainqueue.isEmpty();
    }
}
