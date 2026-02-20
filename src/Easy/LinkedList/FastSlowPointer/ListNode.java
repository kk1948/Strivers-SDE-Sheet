
package Easy.LinkedList.FastSlowPointer;

import java.util.Stack;

public class ListNode {


    public int val;

     public ListNode next;

   public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode reverseWithStack(ListNode head){
        Stack<Integer> valueStack = new Stack<>();
        while(head != null){
            valueStack.push(head.val);
            head = head.next;
        }
        ListNode reversedList = new ListNode(Integer.MIN_VALUE);
        ListNode ptr = reversedList;

        while (!valueStack.isEmpty()){
            ptr.next = new ListNode(valueStack.pop());
            ptr = ptr.next;
        }

        return reversedList.next; //here ptr points to Integer.MIN_VALUE , so we have to move head reversedList.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        // Reverse the list
        ListNode reversedHead = reverseWithStack(head);
        while (reversedHead != null) {
            System.out.print(reversedHead.val + "-> ");
            reversedHead = reversedHead.next;
        }

    }

}
