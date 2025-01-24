class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] currentStatus=new int[graph.length];
        boolean[] isSafe=new boolean[graph.length];
        Arrays.fill(isSafe,true);
        for(int i=0;i<graph.length;i++){
            if(currentStatus[i]==0){
                findAnyCycle(graph,currentStatus,isSafe,i);
            }
        }
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<isSafe.length;i++) if(isSafe[i]) l.add(i);
        return l;
    }
    public boolean findAnyCycle(int[][] graph,int[] currentStatus,boolean[] isSafe,int currentNode){
        if(currentStatus[currentNode]==1){
            isSafe[currentNode]=false;
            currentStatus[currentNode]=2;
            return false;
        }
        if(currentStatus[currentNode]==2){
            return isSafe[currentNode];
        }
        boolean safe=true;
        currentStatus[currentNode]=1;
        for(int edge:graph[currentNode]){
            safe&=findAnyCycle(graph,currentStatus,isSafe,edge);
        }
        currentStatus[currentNode]=2;
        return isSafe[currentNode]=safe;
    }
}
