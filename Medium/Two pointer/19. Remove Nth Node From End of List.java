Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.




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
        if(head==null) return head;
        ListNode p = head;
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast= fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            p=p.next;
            fast=fast.next;
        }
        p.next=p.next.next;
        return head;
    }
}
