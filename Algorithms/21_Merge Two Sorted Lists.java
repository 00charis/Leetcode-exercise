
//非常简单，代码自己写的
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        
        while(l1 != null || l2 != null){
            if(l1 == null){
                p.next = l2;
                l2 = l2.next;
            }
            else if(l2 == null){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                if(l1.val <= l2.val){
                    p.next = l1;
                    l1 = l1.next;
                }
                else{
                    p.next = l2;
                    l2 = l2.next;
                }
            }
            p = p.next;
        }
        return ret.next;
    }
}