class Solution {
    public int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] distance=new int[n][m];
        for(int[] a:distance) Arrays.fill(a,Integer.MAX_VALUE);
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0});
        distance[0][0]=0;
        while(q.size()>0){
            int[] cur=q.poll();
            //System.out.println(cur[0]+" "+cur[1]);
            int currentDir=grid[cur[0]][cur[1]]-1,index=0;
            for(int[] dir:directions){
                int x=cur[0]+dir[0],y=cur[1]+dir[1];
                
                if(x<0||y<0||x>=n||y>=m) {
                    index++;
                    continue;
                }
                int newDistance = distance[cur[0]][cur[1]] + (index == currentDir ? 0 : 1);
                if(newDistance<distance[x][y]){
                    distance[x][y]=newDistance;
                    if(index==currentDir) q.offerFirst(new int[]{x,y});
                    else q.offerLast(new int[]{x,y});
                }
                index++;
            }
        }
        return distance[n-1][m-1];
    }
}
