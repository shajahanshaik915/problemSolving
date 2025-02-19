class Solution {
    int count=0;
    String ans;
    public char[] arr=new char[]{'a','b','c'};
    public String getHappyString(int n, int k) {
        ans="";
        helper(n,"",'z',k);
        return ans;
    }
    public void helper(int n,String cur,char lastChar,int k){
        if(count>k) return;
        if(cur.length()==n){
            count++;
            if(count==k){
                ans=cur;
            }
            return;
        }
        for(char ch:arr){
            if(lastChar!=ch){
                helper(n,cur+ch,ch,k);
            }
        }
    }
}
