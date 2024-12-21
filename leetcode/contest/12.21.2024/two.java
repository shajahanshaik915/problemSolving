class Solution {
    public int[][] direction=new int[][]{{0,1},{1,0}};
    public int mod=1000000007;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        return helper(grid,0,0,n,m,grid[0][0],k,new Integer[n+1][m+1][500]);        
    }
    public int helper(int[][] grid,int i,int j,int n,int m,int xor,int k,Integer[][][] dp){
        if(i==n-1&&j==m-1){
            if(xor==k) return 1;
            return 0;
        }
        //System.out.println(xor);
        if(dp[i][j][xor]!=null) return dp[i][j][xor];
        else{
            long ans=0;
            for(int[] dir:direction){
                int x=dir[0]+i,y=dir[1]+j;
                if(x>=n||y>=m) continue;
                ans=(ans+helper(grid,x,y,n,m,xor^grid[x][y],k,dp))%mod;
            }
            return dp[i][j][xor]=(int)ans;
        }
    }
}
