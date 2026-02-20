package Easy.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;

import static Easy.LinkedList.ReverseList.printList;

public class RemoveElement {

    /// Given the head of a linked list and an integer val,
    /// remove all the nodes of the linked list that has Node.val == val, and return the new head.
    /// Input: head = [1,2,6,3,4,5,6], val = 6
    /// Output: [1,2,3,4,5]
    /// Example 2:
    ///
    /// Input: head = [], val = 1
    /// Output: []
    /// Example 3:
    ///
    /// Input: head = [7,7,7,7], val = 7
    /// Output: []

    public static ListNode removeElements(ListNode head, int value) {
        //1 - if list is empty, return empty


//        while (  head.val == value && head != null) { // here head != null is not before head.val == value, it is giving null pointer exception So
//            //to solve this reverse the position
//            head = head.next;
//        }

        while (  head != null && head.val == value  ) { // here head != null is not before head.val == value, it is giving null pointer exception So
            //to solve this reverse the position
            head = head.next;
        }

        if(head == null) return null;


        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.next.val == value) {
                curr.next = curr.next.next;//skip the val
            }else{
                curr = curr.next;
            }
        }

        return head;

    }



    public static void main (String[] args) {
      ListNode head = new ListNode (5, new ListNode (5 , new ListNode (5, new ListNode (5))));
      int val = 5;

      ListNode result =  removeElements(head, val);
      printList(result);
    }
}
