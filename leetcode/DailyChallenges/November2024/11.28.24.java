class Solution {
    public int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] a:dp) Arrays.fill(a,Integer.MAX_VALUE);
        dp[0][0]=0;
        Deque<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        while(q.size()>0){
            int[] cur=q.poll();
            int i=cur[0],j=cur[1];
            for(int[] direction:directions){
                int x=i+direction[0],y=j+direction[1];
                if(x<0||y<0||x>=grid.length||y>=grid[0].length) continue;
                int nc=dp[i][j]+grid[x][y];
                if(nc<dp[x][y]){
                    dp[x][y]=nc;
                    if(grid[i][j]==1) q.addLast(new int[]{x,y});
                    else q.addFirst(new int[]{x,y});
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
