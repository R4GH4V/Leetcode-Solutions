Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   
   
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            hm.put(inorder[i], i);
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }
    public TreeNode buildTreeHelper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> hm){
        if(is>ie || ps>pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        root.left = buildTreeHelper(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        root.right = buildTreeHelper(postorder, ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        return root;
    }
}
