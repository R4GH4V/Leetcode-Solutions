Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 Recursive solution for binary tree Inorder traversal:
 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res)
    {
        if(root!=null)
        {
            if(root.left!=null){
                helper(root.left, res);
            }
            res.add(root.val);
            if(root.right!=null){
                helper(root.right, res);
            }
        }
    }
}


Iterative solution for Binary tree Inorder traversal:


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty())
        {
            while(cur!=null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
