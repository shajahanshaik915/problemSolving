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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        if(root==null) return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            while(size-->0){
                TreeNode node=q.poll();
                max=Math.max(node.val,max);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            l.add(max);
        }
        return l;
    }
}
