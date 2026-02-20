package Medium.Stack;

public class Main {
    public static void main(String[] args) {
//        StackImplUsingQueues stackImplUsingQueues = new StackImplUsingQueues();
//        stackImplUsingQueues.push(10);
//        stackImplUsingQueues.push(70);
//        stackImplUsingQueues.push(90);
//        System.out.println(stackImplUsingQueues.mainqueue);

        QueueImplUsingStack queueImplUsingStack = new QueueImplUsingStack();
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.top());
        minStack.pop();
        minStack.top();
        minStack.getMin();
        minStack.printStack();







    }
}
