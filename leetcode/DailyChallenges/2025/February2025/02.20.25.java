class Solution {
    Set<String> set;
    String ans;
    public String findDifferentBinaryString(String[] nums) {
        set=new HashSet<>();
        ans="";
        for(String num:nums) set.add(num);
        helper(nums.length,"");
        return ans;
    }
    public boolean helper(int n,String s){
        if(s.length()==n){
            if(set.contains(s)) return false;
            ans=s;
            return true;
        }
        if(helper(n,s+"0")||helper(n,s+"1")) return true;
        return false;
    }
}
