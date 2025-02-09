class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        long count=0;
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i]-i)) count-=m.get(nums[i]-i);
            count+=i;
            m.put(nums[i]-i,m.getOrDefault(nums[i]-i,0)+1);
        }
        return count;
    }
}
