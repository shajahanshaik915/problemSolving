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
    int pre=0,post=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node=new TreeNode(preorder[pre]);
        pre++;
        if(node.val!=postorder[post]){
            node.left=constructFromPrePost(preorder,postorder);
        }
        if(node.val!=postorder[post]){
            node.right=constructFromPrePost(preorder,postorder);
        }
        post++;
        return node;
    }
}
