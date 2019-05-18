//后面半段reverse一下
//这里得到的slow 和 fast，slow停在中间的位置，或者左半边左后的一个元素
private ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode nextnode = curr.next;
			curr.next = pre;
			pre = curr;
			curr= nextnode;
		}
		return pre;
	}
	
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
        		return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
        		slow = slow.next;
        		fast = fast.next.next;
        }
        
        ListNode head2 = reverse(slow.next);
        while(head2 != null) {
        		if(head.val != head2.val) {
        			return false;
        		}
        		head = head.next;
        		head2 = head2.next;
        }
        return true;
    }