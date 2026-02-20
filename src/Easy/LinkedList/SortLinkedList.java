package Easy.LinkedList;


import Easy.LinkedList.FastSlowPointer.ListNode;

import java.util.Arrays;

public class SortLinkedList {


    static ListNode sortLLBruteForce(ListNode head) {
        //travesre the array find the size
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] arr = new int[size];

        //store the node value into the array
        int i = 0;
        ListNode node = head;
        while(node!= null){
            arr[i] = node.val;
            i++;
            node = node.next;
        }

        //sort the array
        Arrays.sort(arr);

        //reffil with node value
        int j = 0;
        ListNode node1 = head;
        while(node1!= null){
             node1.val = arr[j];
            j++;
            node1 = node1.next;
        }
        return head;

    }

    static ListNode sortLLOptimizedMergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1: Split list into two halves
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null; // break into two halves

        // Step 2: Sort both halves
        ListNode leftSorted = sortLLOptimizedMergeSort(head);
        ListNode rightSorted = sortLLOptimizedMergeSort(right);

        // Step 3: Merge sorted halves
        return merge(leftSorted, rightSorted);

    }

    // Utility to find middle node (slow-fast pointer)
    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;

        // Needed to stop fast before it goes null
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted linked lists
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }



    //helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(10, new ListNode(2, new ListNode(4, new ListNode(40))));
        sortLLBruteForce(head);
        printList(head);
    }
}
