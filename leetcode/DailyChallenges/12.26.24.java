class Solution {
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum=0;
        for(int a:nums) totalSum+=a;
        return helper(nums,0,0,target,new Integer[nums.length+1][totalSum*2+1]);
    }
    public int helper(int[] a,int i,int cs,int target,Integer[][] dp){
        
        if(i==a.length){
            if(cs==target) return 1;
            return 0;
        }
        if(dp[i][cs+totalSum]!=null) return dp[i][cs+totalSum];
        int plus=helper(a,i+1,cs+a[i],target,dp);
        int minus=helper(a,i+1,cs-a[i],target,dp);
        return dp[i][cs+totalSum]=plus+minus;
    }
}
