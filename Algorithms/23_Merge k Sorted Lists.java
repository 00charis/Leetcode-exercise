//用分治法写的，代码自己写的
//time complexity: O(nlogk),n是所有节点的个数，k是所有表头的个数
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode mergeK(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        
        //l < r
        int mid = l + (r - l) / 2;
        ListNode first = mergeK(lists, l, mid);
        ListNode second = mergeK(lists, mid + 1, r);
        
        return merge2(first, second);
    }
    
    private ListNode merge2(ListNode l1, ListNode l2){
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
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return mergeK(lists, 0, lists.length - 1);
    }
}