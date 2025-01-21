class Solution {
    public long gridGame(int[][] grid) {
        long top=0,down=0;
        int m=grid[0].length;
        for(int i=0;i<m;i++) top+=grid[0][i];
        long ans=Long.MAX_VALUE;
        for(int i=0;i<m;i++){
            long curBest=0;
            top-=grid[0][i];
            curBest=Math.max(top,down);
            down+=grid[1][i];
            ans=Math.min(ans,curBest);
        }
        return ans;
    }
}
