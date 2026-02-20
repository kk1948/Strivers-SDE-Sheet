package Easy.LinkedList;

import Easy.LinkedList.FastSlowPointer.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPair {
    /// Find Pairs with Given Sum in Doubly Linked List
    /// Given the head of a sorted doubly linked list of positive distinct integers, and a target integer,
    /// return a 2D array containing all unique pairs of nodes (a, b) such that a + b == target.
    /// Each pair should be returned as a 2-element array [a, b] with a < b. The list is sorted in ascending order. If there are no such pairs, return an empty list.
    /// Examples:
    /// Input: head = [1, 2, 4, 5, 6, 8, 9], target = 7
    /// Output: [[1, 6], [2, 5]]
    /// Explanation: 1 + 6 = 7 and 2 + 5 = 7 are the valid pairs.

    private static List<List<Integer>> findPairBruteForce (ListNode head, int target) {
        List<List<Integer>> values = new ArrayList<> ();
        ListNode temp1 = head;
        ListNode temp2;

        while (temp1 != null) {
            temp2 = temp1.next;
            while (temp2 != null && temp1.val + temp2.val <= target) {
                if (temp1.val + temp2.val == target) {
                    values.add (Arrays.asList (temp1.val, temp2.val));
                }
                temp2 = temp2.next;

            }
            temp1 = temp1.next;
        }
        return values;

    }

    private static List<List<Integer>> findPairOptimalApproach (Node head, int target) {
        Node left = head;
        Node right = findtail (head);
        List<List<Integer>> pairs = new ArrayList<> ();
        if (head == null) return pairs;

        while (left.val < right.val) {
            if (left.val + right.val == target) {
                pairs.add (Arrays.asList (left.val, right.val));
                left = left.next;
                right = right.prev;
            } else if (left.val + right.val < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return pairs;

    }

    public static Node findtail (Node head) {
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        return tail;
    }


    public static void main (String[] args) {

        //Singly linked list
        ListNode head = new ListNode (1, new ListNode (2, new ListNode (3, new ListNode (4))));
        int target = 4;
        List<List<Integer>> res = findPairBruteForce (head, target);
        System.out.println (res);

        //doubly linked list


    }
}
