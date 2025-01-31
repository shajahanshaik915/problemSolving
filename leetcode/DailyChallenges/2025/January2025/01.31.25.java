class Solution {
    public int n;
    public int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        n=grid.length;
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,0);
        int id=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int sum=helper(grid,i,j,id);
                    m.put(id,sum);
                    id++;
                }
            }
        }
        
        int result=m.getOrDefault(2,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> set=new HashSet<>();
                    int csum=1;
                    for(int[] dir:directions){
                        int x=dir[0]+i,y=dir[1]+j;
                        if(x<0||y<0||x>=n||y>=n||grid[x][y]==0) continue;
                        set.add(grid[x][y]);
                    }
                    //if(i==1&&j==2) System.out.println(set);
                    for(int a:set) csum+=m.get(a);
                    result=Math.max(result,csum);
                }
            }
        }
        return result;
    }
    public int helper(int[][] grid,int i,int j,int id){
        if(i<0||j<0||i>=n||j>=n||grid[i][j]!=1) return 0;
        grid[i][j]=id;
        int sum=1;
        for(int[] dir:directions){
            int x=dir[0]+i,y=dir[1]+j;
            sum+=helper(grid,x,y,id);
        }
        return sum;
    }
}
