class Solution {
    public int countPartitions(int[] nums) {
        long sum=0;
        for(int num:nums) sum+=num;
        if(sum%2==1) return 0;
        return nums.length-1;
    }
}
