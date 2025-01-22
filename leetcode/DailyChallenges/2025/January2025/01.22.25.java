class Solution {
    int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> q=new LinkedList<>();
        int n=isWater.length,m=isWater[0].length;
        int[][] a=new int[n][m];
        for(int[] b:a) Arrays.fill(b,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=isWater[i][j]==1?0:-1;
                if(a[i][j]==0) q.add(new int[]{i,j});
            }
        }
        int step=1;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int[] pos=q.poll();
                int x=pos[0],y=pos[1];
                for(int[] dir:directions){
                    int nx=x+dir[0],ny=y+dir[1];
                    if(nx<0||ny<0||nx>=n||ny>=m||a[nx][ny]!=-1) continue;
                    a[nx][ny]=step;
                    q.add(new int[]{nx,ny});
                }
            }
            step++;
        }
        return a;
    }
}
