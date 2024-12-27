/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> l;
    public List<Integer> postorderTraversal(TreeNode root) {
        l=new ArrayList<>();
        helper(root);
        return l;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        helper(root.right);
        l.add(root.val);
    }
}
