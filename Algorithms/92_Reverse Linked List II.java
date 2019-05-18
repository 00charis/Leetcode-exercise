//这个逻辑其实是这样的：
//eg: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
//reverse 3 - 6
//过程是这样的：
					
//		(pre)	(start)(then)
// 1 - > 2 -> 4 -> 3 -> 5 -> 6 -> 7
// 1 - > 2 -> 5 -> 4 -> 3 -> 6 -> 7
// 1 - > 2 -> 6 -> 5 -> 4 -> 3 -> 7

//自己用上面的例子在草稿纸上运行几次就知道了。

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
        		return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        //find the previous node of the m th node
        for(int i = 0; i < m - 1; i++) {
        		pre = pre.next;
        }
        
        ListNode start = pre.next;
        ListNode then = start.next;
        
        for(int i = 0; i < n - m; i++) {
        	//这里还是很好记的
        		start.next = then.next;
        		then.next = pre.next;
        		pre.next = then;
        		then = start.next;
        }
        
        return dummy.next;
    }
}
