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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr =  head;
        // Calculate the length of the linkedlist
        while(curr != null){
            length++;
            curr = curr.next;
        }

        // Remove first node if  n==length
        if(n == length) return head.next;

        curr = head; // reset the pointer
        int k = length - n;

        // Reach before the node to be delete
        for(int i=1; i<k; i++){
            curr = curr.next;
        }

        // connect the curr node pointer to deleteNode.next
        curr.next = curr.next.next;

        return head;
    }
}
