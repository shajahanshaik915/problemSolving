class Solution {
    public int[] res;
    public boolean[] used;
    public int max;
    public int[] constructDistancedSequence(int n) {
        res=new int[2*n-1];
        used=new boolean[n+1];
        max=n;
        helper(0);
        return res;
    }
    public boolean helper(int cindex){
        if(cindex>=res.length) return true;
        if(res[cindex]!=0) return helper(cindex+1);
        for(int n=max;n>=1;n--){
            if(used[n]) continue;
            used[n]=true;
            res[cindex]=n;
            if(n==1){
                if(helper(cindex+1)) return true;
            }
            else if(n+cindex<res.length&&res[n+cindex]==0){
                res[n+cindex]=n;
                if(helper(cindex+1)) return true;
                res[n+cindex]=0;
            }
            used[n]=false;
            res[cindex]=0;
        }
        return false;
    }
}
