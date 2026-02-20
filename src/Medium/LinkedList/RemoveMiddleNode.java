package Medium.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;



public class RemoveMiddleNode {

    static ListNode removeMiddleNode(ListNode head){

        if (head == null || head.next == null) return null;


        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast!= null && fast.next!= null){
            prev = slow; // this should be before the slow.next otherwise not work
            slow = slow.next;
            fast = fast.next.next;


        }

        //delete the middle
        prev.next = slow.next;

        //if you dont ake prev pointing to null
//        slow.val = slow.next.val; // slow.val becomes 4
//        slow.next = slow.next.next;
        return head;
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
        ListNode head = new ListNode(10);
        head.next = new ListNode(11);
        head.next.next = new ListNode(12);
        removeMiddleNode(head);
        printList(head);

        ListNode head1 = new ListNode(10, new ListNode(2, new ListNode(4, new ListNode(40))));
        removeMiddleNode(head1);
        printList(head1);
    }
}
