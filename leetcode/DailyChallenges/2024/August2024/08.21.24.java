class Solution {
    public int strangePrinter(String s) {

        return helper(s,0,s.length()-1,new Integer[s.length()][s.length()]);
    }
    public static int helper(String s,int start,int end,Integer[][] dp){
        if(start>end) return 0;
        if(dp[start][end]!=null) return dp[start][end];
        int minTurns=1+helper(s,start+1,end,dp);
        for(int i=start+1;i<=end;i++){
            if(s.charAt(start)!=s.charAt(i)) continue;
            minTurns=Math.min(minTurns,helper(s,start,i-1,dp)+helper(s,i+1,end,dp));

        }
        return dp[start][end]=minTurns;
    }
}
