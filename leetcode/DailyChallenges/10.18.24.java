class Solution {
    
    public int countMaxOrSubsets(int[] nums) {
        int or=0;
        for(int num:nums) or|=num;
        return helper(nums,0,0,or,new Integer[nums.length][or+1]);
        
    }
    public int helper(int[] a,int i,int or,int target,Integer[][] dp){
        if(i>=a.length){
            if(target==or) return 1;
            return 0;
        }
        if(dp[i][or]!=null) return dp[i][or];
        //added
        int added=or|a[i];
        return dp[i][or]=helper(a,i+1,added,target,dp)+helper(a,i+1,or,target,dp);
        
    }
}
