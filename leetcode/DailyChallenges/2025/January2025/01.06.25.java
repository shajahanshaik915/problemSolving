class Solution {
    public int[] minOperations(String s) {
    int n=s.length();
    int[] left=new int[n];int count=s.charAt(0)-'0';
    for(int i=1;i<n;i++){
        left[i]=left[i-1]+count;
        count+=s.charAt(i)-'0';
    }
    int[] right=new int[n];
    count=s.charAt(n-1)-'0';
    for(int i=n-2;i>=0;i--){
        right[i]=right[i+1]+count;
        count+=s.charAt(i)-'0';
    }int[] dp=new int[n];
    for(int i=0;i<n;i++){
        dp[i]=left[i]+right[i];
    }
    return dp;
    }
}
