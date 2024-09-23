class Solution {
    Set<String> set;
    public int minExtraChar(String s, String[] dictionary) {
        set=new HashSet<>();
        for(String dic:dictionary){
            set.add(dic);
        }
        return helper(s,0,new Integer[s.length()]);
    }
    public int helper(String s,int start,Integer[] dp){
        if(start>=s.length()) return 0;
        if(dp[start]!=null) return dp[start];
        int min=s.length();
        
        for(int i=start+1;i<=s.length();i++){
            int count=0;
            String substr=s.substring(start,i);
            if(!set.contains(substr)) count=substr.length();
            count+=helper(s,i,dp);
            min=Math.min(min,count);
        }
        
        return dp[start]=min;
    }
}
