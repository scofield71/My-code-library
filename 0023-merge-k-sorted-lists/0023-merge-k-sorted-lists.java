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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        ListNode tracker = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
        for (int i=0;i<lists.length;i++) {
            if (lists[i]!=null) pq.offer(lists[i]);
        }
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top.next!=null) pq.offer(top.next);
            top.next = null;
            if (ans==null) {
                ans = top;
                tracker = ans;
            } else {
                tracker.next = top;
                tracker = tracker.next;
            }
        }
        return ans;
    }
}