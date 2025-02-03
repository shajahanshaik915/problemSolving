class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        return Math.max(findInc(nums),findDec(nums));
    }
    public int findInc(int[] nums){
        int i=1,n=nums.length,ans=1;
        while(i<n){
            int count=1;
            while(i<n&&nums[i]>nums[i-1]){
                i++;
                count++;
            }
            i++;
            ans=Math.max(ans,count);
        }
        return ans;
    }
    public int findDec(int[] nums){
        int i=1,n=nums.length,ans=1;
        while(i<n){
            int count=1;
            while(i<n&&nums[i]<nums[i-1]){
                i++;
                count++;
            }
            i++;
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
