class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=0,n=nums.length,max=0;
        while(j<n){
            while(j<n&&nums[j]-nums[i]<=(k*2)) j++;
            max=Math.max(j-i,max);
            if(j==n) break;
            while(nums[j]-nums[i]>(k*2)) i++;
        }
        return max;
    }
}


   
