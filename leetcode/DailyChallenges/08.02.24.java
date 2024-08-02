class Solution {
    public int minSwaps(int[] nums) {
    int count=0;
    for(int a:nums){
        if(a==1) count++;
    }
    
    int i=0,j=0,n=nums.length,max=0,ones=0;
    while(j<n+count-1){
        ones+=nums[j%n];
        if(j-i+1<count) j++;
        else{
            max=Math.max(ones,max);
            ones-=nums[i];
            i++;j++; 
        }
    }
        return count-max;
    }
}
