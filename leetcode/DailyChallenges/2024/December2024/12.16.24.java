class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //index ,val
        Queue<int[]> q=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });
        int n=nums.length;
        for(int i=0;i<n;i++){
            q.add(new int[]{i,nums[i]});
        }
        while(k-->0){
            int[] a=q.poll();
            a[1]*=multiplier;
            q.add(a);
        }   
        while(q.size()>0){
            int[] a=q.poll();
            nums[a[0]]=a[1];
        }
        return nums;
    }
}
