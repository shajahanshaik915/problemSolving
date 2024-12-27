class Solution {
    public int[][] directions=new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction=3,x=0,y=0,max=0;
        Set<String> set=new HashSet<>();
        for(int[] obs:obstacles){
            set.add(""+obs[0]+","+obs[1]);
        }
        for(int i=0;i<commands.length;i++){
            int val=commands[i];
            if(val==-1) direction=(direction+1)%4;
            else if(val==-2) direction=(direction+3)%4;
            else{
                int[] directionArray=directions[direction];
                while(val-->0){
                    int newX=directionArray[0]+x,newY=directionArray[1]+y;
                    if(set.contains(""+newX+","+newY)) break;
                    x=newX;
                    y=newY;
                    max=Math.max(max,(x*x)+(y*y));
                }
            }
        }
        return max;
    }
}
