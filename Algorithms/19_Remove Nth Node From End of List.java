//这是one pass的方法，做法参考solution: https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        
        for(int i = 1; i <= n + 1; i++){
            p1 = p1.next;
        }
        
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p2.next = p2.next.next;
        return dummy.next;
    }
}