class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        long ans=0;
        Queue<Integer> q=new PriorityQueue<>((a,b)->{
            if(nums[a]==nums[b]) return a-b;
            return nums[a]-nums[b];
        });
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++) q.add(i);
        while(q.size()>0){
            int i=q.poll();
            if(set.contains(i)) continue;
            ans+=nums[i];
            set.add(i);
            set.add(i+1);
            set.add(i-1);
        }
        return ans;
    }
}
