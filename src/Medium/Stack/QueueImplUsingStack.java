package Medium.Stack;

import java.util.Stack;

public class QueueImplUsingStack {



        Stack<Integer> mainstack;
        Stack<Integer> tempstack;

        public QueueImplUsingStack() {
            mainstack = new Stack<>();
            tempstack = new Stack<>();
        }

        public void push(int x) {
            mainstack.push(x);
        }

        public int pop() {
            int size = mainstack.size();
            for (int i = 0; i < size - 1; i++) {
                tempstack.push(mainstack.pop());
            }
            int frontElement = mainstack.pop();
            Stack<Integer> temp = mainstack;
            mainstack = tempstack;
            tempstack = temp;
            return frontElement;
        }

        public int peek() {
            int size = mainstack.size();
            for (int i = 0; i < size - 1; i++) {
                tempstack.push(mainstack.pop());
            }
            int frontElement = mainstack.peek();
            tempstack.push(mainstack.pop());
            Stack<Integer> temp = mainstack;
            mainstack = tempstack;
            tempstack = temp;
            return frontElement;
        }

        public boolean empty() {
            return mainstack.isEmpty();
        }



}

