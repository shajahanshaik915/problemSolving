class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] a=new int[n];
        a[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i]%2!=nums[i-1]%2){
                a[i]=a[i-1];
            }
            else a[i]=a[i-1]+1;
        }
        boolean[] b=new boolean[queries.length];
        for(int i=0;i<b.length;i++){
            int s=queries[i][0],e=queries[i][1];
            b[i]=a[s]==a[e];
        }
        return b;
    }
}
