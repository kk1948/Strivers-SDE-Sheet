package Easy.LinkedList;
import Easy.LinkedList.FastSlowPointer.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromLinkedList {

   /// Given the head of a linked list, remove the nth node from the end of the list and return its head.

    static ListNode removeNthNodeBruteForce(ListNode head, int n){
        List<Integer> list = new ArrayList<>();

        //traverse the all node & store it to node
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int indextoRemove = list.size() - n;
        list.remove(indextoRemove);

        //build a node
        ListNode dummy = new ListNode(-1);
        ListNode tail = head;
        for(int item : list){
            tail.next= new ListNode(item);
            tail = tail.next;
        }

        return dummy.next;
    }





    public static ListNode removeNthFromEndOptimizedApproach(ListNode head, int n) {
        //        two pointer approach( in one pass )
//        start with two pointer ptr1 and ptr2
//                move ptr2 to n spaces ahead
//                start moving both pointer together , till the next of ptr2 is null
//            you need to remove next of ptr1



        // Step 1: Create a dummy node to handle edge cases (like removing head)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Step 2: Initialize two pointers at dummy
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;

        // Step 3: Move ptr2 n steps ahead
        for (int i = 0; i < n; i++) {
            ptr2 = ptr2.next;
        }

        // Step 4: Move both ptr1 and ptr2 until ptr2.next is null
        while (ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Step 5: Skip the nth node from end
        ptr1.next = ptr1.next.next;

        // Step 6: Return the updated list
        return dummy.next;
    }

    // ✅ Helper: Print Linked List
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }


    // ✅ Helper: Build Linked List from array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int val : values) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;

    }


    public static void main(String[] args) {
        // Test Case 1: [1, 2, 3, 4, 5], n = 2
        ListNode head1 = buildList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original List: ");
        printList(head1);
        head1 = removeNthFromEndOptimizedApproach(head1, 2);
        System.out.print("After Removing 2nd Node from End: ");
        printList(head1);

        // Test Case 2: [1], n = 1
        ListNode head2 = buildList(new int[]{1});
        System.out.print("\nOriginal List: ");
        printList(head2);
        head2 = removeNthFromEndOptimizedApproach(head2, 1);
        System.out.print("After Removing 1st Node from End: ");
        printList(head2);

        // Test Case 3: [1, 2], n = 2
        ListNode head3 = buildList(new int[]{1, 2});
        System.out.print("\nOriginal List: ");
        printList(head3);
        head3 = removeNthFromEndOptimizedApproach(head3, 2);
        System.out.print("After Removing 2nd Node from End: ");
        printList(head3);




    }

}
