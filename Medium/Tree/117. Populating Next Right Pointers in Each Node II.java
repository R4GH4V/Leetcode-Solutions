Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL



public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode tempNode = new TreeLinkNode(0);
        while(root != null){
            TreeLinkNode currNode = tempNode;
            while(root != null){
            if(root.left != null){
                currNode.next = root.left;
                currNode = currNode.next;
            }
            if(root.right != null){
                currNode.next = root.right;
                currNode = currNode.next;
            }
            root = root.next;
            }
            root = tempNode.next;
            tempNode.next = null;
        }
    }
}
