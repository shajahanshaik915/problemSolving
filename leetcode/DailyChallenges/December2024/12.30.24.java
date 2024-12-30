class Solution {
    public int mod=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        return helper(low,high,zero,one,0,new Integer[100005]);
    }
    public int helper(int low,int high,int zero,int one,int len,Integer[] dp){
        if(len>high){
            return 0;
        }
        if(dp[len]!=null) return dp[len];
        int ans=0;
        if(len>=low&&len<=high) ans++;
        
        ans=(ans+helper(low,high,zero,one,len+zero,dp))%mod;
        ans=(ans+helper(low,high,zero,one,len+one,dp))%mod;
        return dp[len]=ans;
    }
}
