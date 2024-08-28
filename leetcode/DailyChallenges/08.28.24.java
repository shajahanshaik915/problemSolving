class Solution {
    public boolean check=true;
    public int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count=0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[0].length;j++){
                if(grid1[i][j]==1&&grid2[i][j]==1){
                    check=true;
                    helper(i,j,grid1,grid2);
                    if(check) count++;
                }
            }
        }
        return count;
    }
    public  void helper(int i,int j,int[][] grid1,int[][] grid2){
        if(i<0||j<0||i>=grid1.length||j>=grid1[0].length||grid2[i][j]!=1){
            return;
        }
        if(grid1[i][j]!=1){
             check=false;
             return;
        }
        grid1[i][j]=0;
        grid2[i][j]=0;
        for(int[] direction:directions){
            int x=i+direction[0],y=j+direction[1];
            helper(x,y,grid1,grid2);
        }
    }
}
