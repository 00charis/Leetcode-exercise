/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//自己写的代码
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        //注意，这里需要写全，不可以写if (l1 || l2 || carry)，这2个简略写法都是不可以的
        while(l1 != null || l2 != null || carry == 1){
            int sum = carry;
            
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            
        }
        
        return dummy.next;
    }
}