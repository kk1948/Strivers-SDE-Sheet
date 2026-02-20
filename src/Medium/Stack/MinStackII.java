package Medium.Stack;

import java.util.Stack;

public class MinStackII {

    //minStack using two stack approach

    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStackII() {
       stack = new Stack<>();
       minstack = new Stack<>();
    }

    public void push(int val) {
       stack.push(val);

       if(minstack.isEmpty() || val <= minstack.peek()){ // push value when it is empty or current val less than or equals to current minimum
           minstack.push(val);

       }
    }

    public void pop() {
        //stack.pop(); here no need to pop twice
        int poppedval = stack.pop();  // this will do the same thing pop the element


        if(poppedval == minstack.peek()){ // pop from minstack if pop val from main satck is equals to minstack
            minstack.pop();
        }
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
      return minstack.peek();
    }
}
