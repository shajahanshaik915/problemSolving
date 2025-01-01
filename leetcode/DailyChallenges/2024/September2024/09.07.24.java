/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean ans;
    public List<Integer> l;
    public boolean isSubPath(ListNode head, TreeNode root) {
        ans=false;
        l=new ArrayList<>();
        while(head!=null){
            l.add(head.val);
            head=head.next;
        }
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        if(root.val==l.get(0)){
            check(root,0);
        }
        helper(root.left);
        helper(root.right);
    }
    public void check(TreeNode root,int index){
        if(index>=l.size()){
            ans=true;
            return;
        }
        if(root==null||root.val!=l.get(index)){
            return;
        }
        System.out.println(root.val+" "+index);
        check(root.left,index+1);
        check(root.right,index+1);
    }
}
