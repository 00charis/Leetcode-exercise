//这是moon写的思路
//First, find the middle pointer(head of the right half list) using "slow-fast-pointer" method
//Second, reverse the right half list
//Third, merge left half and right half list
    
//注意，slow停在什么位置
//如果是： 1-> 2-> 3-> 4-> null ，slow停在2的位置
//如果是：1-> 2-> 3-> 4-> 5-> null ，slow停在3的位置

class Solution {
    //这个只是把链表的关系重新连接一下，表头还是head指向的那个结点
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = reverse(slow.next);
        slow.next = null;   //important! Otherwise Memory Limit Exceed
        merge(head, l2);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    
    //左边参数的节点数 = 右边参数的节点数 或者比右边参数的节点数大1
    //只是把链表指针重新链一下，表头是l1原来指向的结点
    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }

}