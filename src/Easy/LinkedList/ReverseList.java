package Easy.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;

import java.util.Stack;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {
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

        return reversedList.next;
    }


    public static ListNode reverseListInPlaceTraversal(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev; // new head
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next  = new ListNode(5);
        head.next.next = new ListNode(10);

        ListNode result = reverseListInPlaceTraversal(head);
        printList(result);


    }
}
