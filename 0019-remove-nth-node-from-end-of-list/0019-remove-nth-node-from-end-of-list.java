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
        ListNode start = head;
        ListNode prev = null;
        int cnt = 1;
        while (cnt<n) {
            start = start.next;
            cnt++;
        }
        if (start.next==null) return head.next;
        ListNode slow = head;
        while(start.next!=null) {
            prev = slow;
            slow = slow.next;
            start = start.next;
        }
        prev.next=slow.next;
        return head;
    }
}