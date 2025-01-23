class Solution {
    public int countServers(int[][] grid) {
        int ans=0,n=grid.length,m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) continue;
                int count=markAllConnected(grid,i,j,new Integer[n][m]);
                if(count!=1) ans+=count;
            }
        }
        return ans;
    }
    public int markAllConnected(int[][] grid,int x,int y,Integer[][] dp){
        //System.out.println(x+" "+y);
        if(dp[x][y]!=null) return dp[x][y];
        grid[x][y]=0;int count=1;
        for(int i=0;i<grid.length;i++){
            if(grid[i][y]==1) count+=markAllConnected(grid,i,y,dp);
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[x][i]==1) count+=markAllConnected(grid,x,i,dp);
        }
        //System.out.println(count);
        return dp[x][y]=count;
    }
}
