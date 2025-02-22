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
    public int index;
    public String s;
    public TreeNode recoverFromPreorder(String traversal) {
        index=0;
        s=traversal;
        int number=findNumber();
        return helper(number,0);
    }
    public TreeNode helper(int number,int previousDash){
        TreeNode node=new TreeNode(number);
        int nextDash=findDash();
        if(nextDash<=previousDash) return node;
        index+=nextDash;
        node.left=helper(findNumber(),nextDash);
        nextDash=findDash();
        if(nextDash<=previousDash) return node;
        index+=nextDash;
        node.right=helper(findNumber(),nextDash);
        return node;
    }
    public int findDash(){
        int i=index;
        while(i<s.length()&&s.charAt(i)=='-') i++;
        return i-index;
    }
    public int findNumber(){
        // System.out.println(s+" lengthis-> "+s.length());
        // System.out.println(index);
        String str="";
        while(index<s.length()&&Character.isDigit(s.charAt(index))){
            str+=s.charAt(index);
            index++;
        }
        return Integer.parseInt(str);
    }
}
