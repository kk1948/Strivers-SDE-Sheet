package Medium.Stack;

public class StackImplUsingArray {
    int top = -1;
    public int[] stack = new int[10];

    public StackImplUsingArray() {

    }

    public void push(int val){

        top++;
        stack[top] = val;
    }
    public void pop() {
        if(top == -1){
            System.out.println ("Stack is empty");
        }
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int  size(){
        return top + 1;
    }



    public  void display(){
        System.out.print("Elements are : ");
        for (int i = 0; i <= top; i++) {
            System.out.print ( stack[i] +" ");
        }
        System.out.println ();
    }
}
