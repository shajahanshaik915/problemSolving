class Solution {
    int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int findMaxFish(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    max=Math.max(max,dfs(grid,i,j));
                    
                }
            }
        }
        
        return max;
    }
    public int dfs(int[][] grid,int i,int j){
        
        int count=grid[i][j];
        grid[i][j]=0;
        for(int[] direction:directions){
            int x=direction[0]+i,y=direction[1]+j;
            if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==0) continue;
            count+=dfs(grid,x,y);
        }
        return count;
    }
}
