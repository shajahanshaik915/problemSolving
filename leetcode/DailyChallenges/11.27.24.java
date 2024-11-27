class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer,Set<Integer>> m=new HashMap<>();
        for(int i=1;i<n;i++){
            m.put(i-1,new HashSet<>());
            m.get(i-1).add(i);
        }
        m.put(n-1,new HashSet<>());
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            m.get(query[0]).add(query[1]);
            ans[i]=bfs(m,n);
        }
        return ans;
    }
    public int bfs(Map<Integer,Set<Integer>> m,int n){
        int steps=0;
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited.add(0);
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int a=q.poll();
                if(a==n-1) return steps;
                for(int b:m.get(a)){
                    if(!visited.contains(b)){
                        q.add(b);
                        visited.add(b);
                    }
                }
            }
            steps++;   
        }
        return -1;
    }
}
