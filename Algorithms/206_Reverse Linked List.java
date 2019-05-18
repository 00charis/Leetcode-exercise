//参考solution: https://leetcode.com/problems/reverse-linked-list/solution/


//v1: iterative 非常基础，非常重要
// Complexity analysis
// Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n)
// Space complexity : O(1).
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}



//v2: recursive
// Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).

// Space complexity : O(n). 
// The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}