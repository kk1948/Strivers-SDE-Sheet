package Easy.LinkedList.FastSlowPointer;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLinkedList {

    static ListNode intersectionBruteForce(ListNode headA, ListNode headB){
        Set<ListNode> list = new HashSet<>();

        //step 1: store all nodes of ListA
        while (headA!= null){
            list.add(headA);
            headA = headA.next;
        }

        while (headB!= null){
            if (list.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return  null;
    }

    //Space optimized approach
    public static ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Advance the pointer of the longer list
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Move both pointers and check for intersection
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA; // or headB
    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }


    /**
     * @param head
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        // Shared Node (intersection)
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(10);

        // List A: 4 -> 1 -> 8 -> 10
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        // List B: 5 -> 6 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        ListNode headC = getIntersectionNodeOptimized(headA, headB);
        printList(headC);
    }
}
