class Solution {
    public PriorityQueue<Integer> max;
    public PriorityQueue<Integer> min;
    public long continuousSubarrays(int[] nums) {
        max=new PriorityQueue<>((a,b)->b-a);
        min=new PriorityQueue<>();
        int i=0,n=nums.length;
        long ans=0;
        for(int j=0;j<n;j++){
            max.add(nums[j]);
            min.add(nums[j]);

            while(i<j&&max.peek()-min.peek()>2){
                max.remove(nums[i]);
                min.remove(nums[i]);
                i++;
            }
            ans+=j-i+1;
        }
        return ans;
    }
}
