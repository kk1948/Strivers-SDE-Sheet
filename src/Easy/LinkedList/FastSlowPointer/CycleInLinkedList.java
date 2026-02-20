package Easy.LinkedList.FastSlowPointer;

import java.util.HashSet;
import java.util.Set;

public class CycleInLinkedList {


    public static boolean hasCycleusingStack(ListNode head){

        //Create A SET
        Set<ListNode> visited = new HashSet<>();

        ListNode current = head;
        while(current!= null){
            if(visited.contains(current)) return true;
            visited.add(current);
            current = current.next;
        }
        return false;
    }

    // Floyd detectection method
    public static boolean hasCycleusingFastndSlowPtr(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // Create nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Link nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create a cycle (last node connects back to second)
        fourth.next = second; // cycle here

        // Detect cycle
        boolean result = hasCycleusingStack(head);
        boolean result1 = hasCycleusingFastndSlowPtr(head);
        System.out.println("Cycle detected? " + result);
        System.out.println("Cycle detected? " + result1);
    }
}
