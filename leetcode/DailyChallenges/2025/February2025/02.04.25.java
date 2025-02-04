class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0],n=nums.length,i=1,max=sum;
        while(i<n){
            sum=nums[i-1];
            while(i<n&&nums[i]>nums[i-1]){
                sum+=nums[i];
                i++;
            }
            max=Math.max(max,sum);   
            i++;
        }
        return max;
    }
}
