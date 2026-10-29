/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        // 1. Find the middle and divide
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Head of second half is slow.next;
        ListNode secondHalfHead = slow.next;
        // Split the list into two separate halves
        slow.next = null;

        // 2. Reverse the second half.
        ListNode prev = null;
        ListNode curr = secondHalfHead;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Merge
        ListNode list1 = head;
        ListNode list2 = prev;

        while(list1 != null && list2 != null){
            // First preserve the pointers for the next
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;

            //connect
            list1.next = list2;
            list2.next = next1;

            //update pointers to preserved ones
            list1 = next1;
            list2 = next2;
        }
    }
}
