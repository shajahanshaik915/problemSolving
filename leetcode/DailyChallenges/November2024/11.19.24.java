class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        int i=0,j=0,n=nums.length;
        long max=0,sum=0;
        while(j<n){
            while(j-i+1<k){
                sum+=nums[j];
                m.put(nums[j],m.getOrDefault(nums[j],0)+1);
                j++;
            }
            sum+=nums[j];
            m.put(nums[j],m.getOrDefault(nums[j],0)+1);
            if(m.keySet().size()==k){
                max=Math.max(max,sum);
            }
            sum-=nums[i];
            
            m.put(nums[i],m.get(nums[i])-1);
            if(m.get(nums[i])==0) m.remove(nums[i]);
            i++;j++;
        }
        return max;
    }
}
