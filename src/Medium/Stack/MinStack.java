package Medium.Stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainstack;

    public MinStack() {
         mainstack = new Stack<>();
    }

    public void push(int val) {
         mainstack.push(val);
    }

    public void pop() {
        if (!mainstack.isEmpty()) {
            mainstack.pop();
        }
    }

    public int top() {
        if (mainstack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return mainstack.peek();
    }

    public int getMin() {
        Stack<Integer> temp = new Stack<>();
        int min = Integer.MAX_VALUE;

        while (!mainstack.isEmpty()){
            int current =  mainstack.pop();
            if(current < min){
                min = current;
            }
            temp.push(current);
        }

        while (!temp.isEmpty()){
            mainstack.push(temp.pop());
        }
        return min;
    }

    public void printStack() {
        for (int val : mainstack) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
