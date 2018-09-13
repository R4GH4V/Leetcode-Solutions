Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            hm.put(inorder[i], i);
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hm);
    }
    public TreeNode buildTreeHelper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer, Integer> hm){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int ri = hm.get(preorder[ps]);
        root.left = buildTreeHelper(preorder, ps+1, ps+ri-is, inorder, is, ri-1, hm);
        root.right = buildTreeHelper(preorder, ps+ri-is+1, pe, inorder, ri+1, ie, hm);
        return root;
    }
}
