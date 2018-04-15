You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]



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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int n= q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){                
                TreeNode node = q.poll();
                max = Math.max(max,node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);                
            }
            res.add(max);
        }
        return res;
    }
}
