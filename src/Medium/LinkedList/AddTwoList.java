package Medium.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;

public class AddTwoList {

        public  static ListNode addtwoListBruteForce(ListNode l1, ListNode l2){

            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            int carry = 0;

            while(l1 != null || l2 != null || carry != 0){

                int val1 = (l1 != null) ? l1.val : 0;
                int val2 = (l2 != null) ? l2.val : 0;
                int sum = val1 + val2 + carry;
                int currentDigit = sum % 10;
                carry = sum / 10;


                // create new node with currentDigit and attach to current
                // move current to new node
                ListNode newnode = new ListNode(currentDigit);
                current.next = newnode;
                current = current.next;

                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;


            }


            return dummy.next;



        }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Step 1: Create first linked list (e.g., 2 -> 4 -> 3)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Step 2: Create second linked list (e.g., 5 -> 6 -> 7)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        // Step 3: Call addTwoListBruteForce method
        ListNode result = AddTwoList.addtwoListBruteForce(l1, l2);
        printList(result);
    }
}
