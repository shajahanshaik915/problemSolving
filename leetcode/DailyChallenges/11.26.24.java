class Solution {
    public int findChampion(int n, int[][] edges) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++) m.put(i,0);
        for(int[] edge:edges){
            int a=edge[0],b=edge[1];
            m.put(b,m.get(b)+1);
        }
        int count=0,ans=-1;
        for(int key:m.keySet()){
            if(m.get(key)==0){
                count++;
                ans=key;
            }
        }
        if(count==1) return ans;
        return -1;
    }
}
