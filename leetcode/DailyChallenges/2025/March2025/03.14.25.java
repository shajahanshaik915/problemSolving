class Solution {
    public int maximumCandies(int[] candies, long k) {
        int i=1,j=0,ans=0;
        for(int candie:candies) j=Math.max(candie,j);
        while(i<=j){
            int mid=i-(i-j)/2;
            if(check(candies,k,mid)){
                ans=mid;
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return ans;
    }
    public boolean check(int[] candies,long childern,int count){
        long total=0;
        for(int candie:candies){
            total+=candie/count;
        }
        return total>=childern;
    }
}
