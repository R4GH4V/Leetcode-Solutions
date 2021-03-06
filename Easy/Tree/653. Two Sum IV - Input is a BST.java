Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<Integer>();
        return find(root, k, hs);
    }
    
    public boolean find(TreeNode root, int k, HashSet<Integer> hs){
        if(root == null)
            return false;
        if(hs.contains(k-root.val))
            return true;
        hs.add(root.val);
        return find(root.left,k,hs) || find(root.right,k,hs);
    }
}
