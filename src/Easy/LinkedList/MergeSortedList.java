package Easy.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortedList {


    private ListNode mergeListBruteForce(ListNode list1, ListNode list2){
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        List<Integer> values = new ArrayList<>();

        //add valuse of list1 into Arraylist
        while(temp1!= null){
            values.add(temp1.val);
            temp1 = temp1.next;
        }

        while(temp2!= null){
            values.add(temp2.val);
            temp2 = temp2.next;
        }

        Collections.sort(values);

        // Step 4: Build new linked list from sorted values
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int val : values) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }

        return dummy.next;

    }

    public  ListNode mergeTwoSortedListsOptimized(ListNode l1, ListNode l2) {
        // Dummy node simplifies edge cases
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Merge while both lists have nodes
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

        // Attach the remaining nodes (only one of these will run)
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next; // return head of merged list
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }




    public static void main(String[] args) throws IOException {

        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        MergeSortedList obj = new MergeSortedList();
        ListNode merged = obj.mergeListBruteForce(list1, list2);
        ListNode merged1 = obj.mergeTwoSortedListsOptimized(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
        printList(merged1);

        System.gc();
        System.out.println("Program running... Attach JConsole now. Press Enter to exit.");
        System.in.read();
    }
}
