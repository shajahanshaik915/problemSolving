class Solution {
    public int count;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        count=0;
        Map<Integer,Set<Integer>> m=new HashMap<>();
        for(int i=0;i<n;i++) m.put(i,new HashSet<>());
        for(int[] edge:edges){
            m.get(edge[0]).add(edge[1]);
            m.get(edge[1]).add(edge[0]);
        }
        dfs(m,values,0,-1,k);
        return count;
    }
    public int dfs(Map<Integer,Set<Integer>> m,int[] values,int current,int parent,int k){
        int sum=values[current]%k;
        for(int nei:m.get(current)){
            if(nei==parent) continue;
            sum=(sum+dfs(m,values,nei,current,k))%k;
        }
        if(sum%k==0) count++;
        return sum%k;
    }
}
