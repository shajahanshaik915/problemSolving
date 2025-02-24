class Solution {
    Map<Integer,Set<Integer>> m;
    List<Integer> path;
    public int ans;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        m=new HashMap<>();
        path=new ArrayList<>();
        ans=Integer.MIN_VALUE;
        for(int[] edge:edges){
            int a=edge[0],b=edge[1];
            m.putIfAbsent(a,new HashSet<>());
            m.putIfAbsent(b,new HashSet<>());
            m.get(a).add(b);
            m.get(b).add(a);
        }
        path.add(bob);
        getPath(bob,-1);
        if(path.size()%2==1){
            for(int i=0;i<path.size()/2;i++) amount[path.get(i)]=0;
            amount[path.get(path.size()/2)]/=2;
        }
        else for(int i=0;i<path.size()/2;i++) amount[path.get(i)]=0;
        helper(0,amount,-1,0);
        //System.out.println(m);
        return ans;
    }
    
    public void helper(int c,int[] amount,int parent,int t){
        if(c!=0&&m.get(c).size()==1){
            ans=Math.max(ans,t+amount[c]);
        }
        for(int n:m.get(c)){
            if(n==parent) continue;
            helper(n,amount,c,t+amount[c]);
        }
    }

    public boolean getPath(int start,int parent){
        if(start==0){
            return true;
        }
        for(int next:m.get(start)){
            if(next==parent) continue;
            path.add(next);
            if(getPath(next,start)) return true;
            path.remove(path.size()-1);
        }
        return false;
    }
}
