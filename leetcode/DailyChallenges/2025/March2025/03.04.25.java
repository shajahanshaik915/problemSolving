class Solution {
    public boolean checkPowersOfThree(int n) { 
        return helper(n,0,0,new Boolean[18][n+1]);   
    }
    public boolean helper(int n,int pow,int cur,Boolean[][] dp){
        //System.out.println(n+" "+pow+" "+cur);
        if(cur==n) return true;
        if(cur>n||cur+(int)Math.pow(3,pow)>n) return false;
        if(dp[pow][cur]!=null) return dp[pow][cur];
        return dp[pow][cur]=helper(n,pow+1,cur+(int)Math.pow(3,pow),dp)||helper(n,pow+1,cur,dp);
    }
}
