Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?


Using the Hare and Tortoise algorithm (using 2 pointers, one moving slower and another faster):

class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head==NULL || head->next==NULL)
            return false;
        ListNode *slow=head;
        ListNode *fast=head->next;
        while(true)
        {
            if(fast==NULL || fast->next==NULL)
                return false;
            else if(fast==slow || fast->next==slow)
                return true;
            else
            {
                slow=slow->next;
                fast=fast->next->next;
            }
        }
    }
};
