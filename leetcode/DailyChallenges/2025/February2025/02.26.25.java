class Solution {
    public int maxAbsoluteSum(int[] nums) {
    int max=maxSubArray(nums);
    int min=minSumArray(nums);
    return Math.max(Math.abs(max),Math.abs(min));
    }
    public static int maxSubArray(int[] a){
        int os=a[0],cs=a[0];
        for(int i=1;i<a.length;i++){
            if(cs+a[i]<a[i]) cs=a[i];
            else cs+=a[i];
            os=Math.max(os,cs);
        }
        return os;
    }
    public static int minSumArray(int[] a){
        int cs=a[0],os=a[0];
        for(int i=1;i<a.length;i++){
            if(cs+a[i]>a[i]) cs=a[i];
            else cs+=a[i];
            os=Math.min(cs,os);
        }
        return os;
    }
}
