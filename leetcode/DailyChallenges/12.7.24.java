class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int i=1,j=findMax(nums);
        while(i<j){
            int mid=(i+j)/2;
            int splits=findMaxSplit(nums,mid);
            if(maxOperations<splits){
                
                i=mid+1;
            }
            else{
                
                j=mid;
            }
        }
        return j;
    }
    public int findMax(int[] a){
        int max=0;
        for(int b:a) max=Math.max(max,b);
        return max;
    }
    public int findMaxSplit(int[] a,int mid){
        int count=0;
        for(int b:a){
            count+=Math.ceil(b/(double)mid)-1;
        }
        return count;
    }
}
