package Medium.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;

import static Medium.LinkedList.RemoveMiddleNode.printList;

public class RoatateList {

    static ListNode rotateListByKtimes (ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;


        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        //Case 1- if k and length of list is equal, return head
        if (k % length == 0) return head;

        k = k % length;
        tail.next = head;

        // Find new tail: (length - k)th node
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Set new head and break the loop
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;


    }

    public static void main (String[] args) {

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        ListNode rotatedHead = rotateListByKtimes(head, k);

        System.out.println("Rotated List by " + k + " positions:");
        printList(rotatedHead);
    }
}
