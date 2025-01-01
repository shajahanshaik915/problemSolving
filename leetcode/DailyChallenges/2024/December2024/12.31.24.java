class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return helper(days,0,costs,0,new Integer[days.length+2][400]);
    }
    public int helper(int[] days,int index,int[] costs,int lastDay,Integer[][] dp){
        
        if(index>=days.length) return 0;
        if(dp[index][lastDay]!=null) return dp[index][lastDay];
        if(lastDay>=days[index]){
            while(index<days.length&&days[index]<=lastDay) index++;
            return helper(days,index,costs,lastDay,dp);
        }
        int oneday=costs[0]+helper(days,index,costs,days[index],dp);
        int sevenday=costs[1]+helper(days,index,costs,days[index]+6,dp);
        int thirtyday=costs[2]+helper(days,index,costs,days[index]+29,dp);
        return dp[index][lastDay]=Math.min(oneday,Math.min(sevenday,thirtyday));
    }
}
