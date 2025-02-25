class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] arr) {
        int even=1,odd=0,sum=0;
        long count=0;
        for(int a:arr){
            sum+=a;
            if(sum%2==1){
                count=(count+even)%mod;
                odd++;
            }
            else{
                count=(count+odd)%mod;
                even++;
            }
        }
        return (int)(count%mod);
    }
}
