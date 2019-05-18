//用2个指针定位
//注意：k有可能比cnt大。题目的要求是向右移k个位置
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //corner case
    		if(head == null || k == 0) {
    			return head;
    		}
        ListNode fast = head;
        int cnt = 1;
        while(fast.next != null) {
        		fast = fast.next;
        		cnt ++;
        }
        //cnt is the total num of listnodes, cnt is the total number
        
        //find the cnt - k th List
        int idx = cnt - k % cnt;
        ListNode slow = head;
        for(int i = 0; i < idx - 1; i++) {
        		slow = slow.next;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}