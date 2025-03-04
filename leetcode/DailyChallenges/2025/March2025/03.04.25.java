class Solution {
    public boolean checkPowersOfThree(int n) {
        return helper(n,0,0);
    }
    public boolean helper(int n,int pow,int cur){
        //System.out.println(n+" "+pow+" "+cur);
        if(cur==n) return true;
        if(cur>n||cur+(int)Math.pow(3,pow)>n) return false;
        return helper(n,pow+1,cur+(int)Math.pow(3,pow))||helper(n,pow+1,cur);
    }
}
