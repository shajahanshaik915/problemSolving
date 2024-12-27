class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer,Set<Integer>> m1=helper(edges1);
        Map<Integer,Set<Integer>> m2=helper(edges2);
        int dia1=findDia(m1),dia2=findDia(m2);
        int ans=Math.max(dia1,dia2);
        if(dia1%2==1) dia1++;
        if(dia2%2==1) dia2++;
        return Math.max(ans,1+(dia1)/2+(dia2)/2);
    }
    public int findDia(Map<Integer,Set<Integer>> m){
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        q.add(0);
        set.add(0);
        int ans=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int a=q.poll();
                for(int b:m.get(a)){
                    if(set.contains(b)) continue;
                    ans=b;
                    set.add(b);
                    q.add(b);
                }
            }
        }
        set=new HashSet<>();
        q.add(ans);
        set.add(ans);
        int dist=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int a=q.poll();
                for(int b:m.get(a)){
                    if(set.contains(b)) continue;
                    set.add(b);
                    q.add(b);
                }
            }
            dist++;
        }
        return dist-1;
    }
    public Map<Integer,Set<Integer>> helper(int[][] edges){
        Map<Integer,Set<Integer>> m=new HashMap<>();
        int n=edges.length;
        for(int i=0;i<=n;i++) m.put(i,new HashSet<>());
        for(int[] edge:edges){
            m.get(edge[0]).add(edge[1]);
            m.get(edge[1]).add(edge[0]);
        }
        return m;
    }
}
