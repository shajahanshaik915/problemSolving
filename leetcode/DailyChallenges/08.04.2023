class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> sum=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            long currentSum=0;
            for(int j=i;j<nums.length;j++){
                currentSum=(currentSum+nums[j])%1000000007;
                sum.add(currentSum);
            }
        }
        Collections.sort(sum);
        long ans=(long)0;
        for(int i=left-1;i<right;i++){
            ans=(ans+sum.get(i))%1000000007;
        }
        
        return (int)(ans%1000000007);
    }
}
