class Solution {
    public int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumTime(int[][] grid) {
        if(grid[1][0]>1&&grid[0][1]>1) return -1;
        int n=grid.length,m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] a:dp) Arrays.fill(a,-1);
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        dp[0][0]=0;
        while(q.size()>0){
            int[] cur=q.poll();
            int i=cur[0],j=cur[1];
            int time=dp[i][j]+1; // TIme to reac next cell.....
            //System.out.println(i+" "+j+" time tocome to this cell: "+dp[i][j]);
            for(int[] direction:directions){
                int x=direction[0]+i,y=direction[1]+j;
                if(x<0||y<0||x>=n||y>=m) continue;
                int newTime=time;
                if(time<grid[x][y]){
                    int diff=grid[x][y]-time;
                    if(diff%2==1) diff++;
                    newTime+=diff;
                }
                if(newTime>=grid[x][y]&&(dp[x][y]==-1||dp[x][y]>newTime)){
                    dp[x][y]=newTime;
                    q.add(new int[]{x,y});
                }
            }
        }
        return dp[n-1][m-1];
    }
}
