Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.


Time Complexity O(n) Space Complexity O(1) solution using difference of lengths of lists, making the longer list travel the difference
and using two pointers

public class Solution {
    
    public int l_length(ListNode n)
    {
        int len=0;
        while(n!=null)
        {
            len++;
            n=n.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                    int n=l_length(headA);
                    int m=l_length(headB);
                    int d=Math.abs(n-m);         //Difference in length of LinkedLists
                    if(n>m)
                    {
                        for(int i=0;i<d;i++)
                        headA=headA.next;
                    }
                    else                    //m>n
                    {
                        for(int i=0;i<d;i++)
                        headB=headB.next;
                    }
                    while(headA!=null && headB!=null)
                    {
                        if(headA==headB)
                            return headA;
                        else
                        {
                            headA=headA.next;
                            headB=headB.next;
                        }
                    }
        return null;
    }
}

---Author: hpplayer's Solution:

I found most solutions here preprocess linkedlists to get the difference in len.
Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.

We can use two iterations to do that. 
In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node.
In the second iteration, we will move two pointers until they points to the same node. Our operations in first iteration will help us counteract the difference. So if two linkedlist intersects, the meeting point in second iteration must be the intersection point. 
If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null

Below is my commented Java code:

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
