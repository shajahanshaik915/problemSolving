class Solution {
    public int[] sortArray(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public int[] helper(int[] nums,int i,int j){
        
        if(j-i<=1){
            if(j==i){
                
                 return new int[]{nums[i]};
            }
            else{
                
                return new int[]{Math.min(nums[i],nums[j]),Math.max(nums[i],nums[j])};
            }
        }
        else{
            int mid=(i+j)/2;
            int[] left=helper(nums,i,mid);
            int[] right=helper(nums,mid+1,j);
            int[] ans=new int[j-i+1];
            int leftIndex=0,rightIndex=0,mainIndex=0;
            while(leftIndex<left.length&&rightIndex<right.length){
                if(left[leftIndex]<=right[rightIndex]){
                    ans[mainIndex]=left[leftIndex];
                    leftIndex++;
                    mainIndex++;
                }
                else{
                    ans[mainIndex]=right[rightIndex];
                    rightIndex++;
                    mainIndex++;
                }
            }
            while(leftIndex<left.length){
                ans[mainIndex]=left[leftIndex];
                leftIndex++;
                mainIndex++;
            }
            while(rightIndex<right.length){
                ans[mainIndex]=right[rightIndex];
                rightIndex++;
                mainIndex++;
            }
            
            return ans;
        }
    }
}
