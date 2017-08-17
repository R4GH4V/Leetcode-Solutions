Reverse a singly linked list.


public class Solution {
    public ListNode reverseList(ListNode head) {
            if(head==null) return null;
            ListNode curr=head;
            ListNode prev=null;
            ListNode temp=null;
            while(curr!=null)
            {
                temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
        return prev;
    }
}
