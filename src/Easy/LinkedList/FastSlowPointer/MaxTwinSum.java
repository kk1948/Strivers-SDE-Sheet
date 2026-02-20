package Easy.LinkedList.FastSlowPointer;

import java.util.ArrayList;
import java.util.List;

public class MaxTwinSum {

    public static int pairSum(ListNode head) {

        List<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        // List - [ 5, 4 , 2, 1]
        int i = 0, j= list.size() - 1;
        int max = Integer.MIN_VALUE;
        while(i<j){
            int candidate = list.get(i) + list.get(j);
            max = Math.max(max, candidate);
            i++;
            j--;
        }

        return max;

    }


    public static void main(String[] args) {
//         ListNode head = new ListNode(5);
//         head.next = new ListNode(4);
//         head.next.next = new ListNode(2);
//         head.next.next.next = new ListNode(1);

         //annter way to create List
        ListNode head = new ListNode(5, new ListNode(4,new ListNode(2,new ListNode(1)) ) );

        int res = pairSum(head);
        System.out.println(res);



    }
}
