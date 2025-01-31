class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,Set<Integer>> m=new HashMap<>();
        int[] parent=new int[edges.length+1];
        Arrays.fill(parent,-1);
        for(int[] edge:edges){
            int parentOfA=find(edge[0],parent), 
            parentOfB=find(edge[1],parent);
            
            if(parentOfA==parentOfB){
                return edge;
            }
            parent[parentOfA]=parentOfB;
            
        }
        
        return null;
    }
    public int find(int node,int[] parent){
        if(parent[node]==-1) return node;
        return find(parent[node],parent);
    }
}
