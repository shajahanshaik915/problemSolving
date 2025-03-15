class Solution {
    public int maxProfit(int[] prices) {
        int cmin=prices[0],ans=0;
        for(int i=1;i<prices.length;i++){
            ans=Math.max(prices[i]-cmin,ans);
            cmin=Math.min(prices[i],cmin);
        }
        return ans;
    }
}
