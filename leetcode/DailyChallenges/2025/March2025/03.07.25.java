class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime=new boolean[right+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i<=(int)Math.sqrt(right);i++){
            if(isPrime[i]){
                int mul=i*i;
                while(mul<=right){
                    isPrime[mul]=false;
                    mul+=i;
                }
            }
        }
        int[] ans=new int[]{-1,-1};
        int diff=Integer.MAX_VALUE;
        int prev=-1;
        for(int i=left;i<=right;i++){
            if(isPrime[i]){
                if(prev!=-1&&diff>i-prev){
                    ans=new int[]{prev,i};
                    diff=i-prev;
                }
                prev=i;
            }
        }
        return ans;
    }
}
