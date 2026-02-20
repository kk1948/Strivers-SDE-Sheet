package Medium.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;

import static Easy.LinkedList.ReverseList.*;

public class AddOneInList {
    /// Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.
    /// The number will contain no leading zeroes except when the value represented is zero itself.
    /// Examples:
    /// Input: head -> 1 -> 2 -> 3
    /// Output: head -> 1 -> 2 -> 4
    /// Explanation: The number represented by the linked list = 123.
    /// 123 + 1 = 124.

    public static ListNode addOne(ListNode head) {

        int carry = 1; // start with 1 because we are adding 1
        ListNode current = head;

        while (current != null) {
            int sum = current.val + carry;
            current.val = sum % 10;
            carry = sum / 10;

            // if next is null and carry is still > 0, create a new node
            if (current.next == null && carry > 0) {
                current.next = new ListNode(carry);
                carry = 0; // no more carry left
            }

            current = current.next;
        }

        return head; // head is still reversed, will reverse back later
    }

    public static ListNode addOneToList(ListNode head) {
        // Step 1: Reverse the list
        ListNode reversedHead = reverseListInPlaceTraversal(head);

        // Step 2: Add 1
        addOne(reversedHead);

        // Step 3: Reverse back to original order

        return reverseListInPlaceTraversal(reversedHead);
    }





    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        addOneToList(head);
        printList(head);

    }

}
