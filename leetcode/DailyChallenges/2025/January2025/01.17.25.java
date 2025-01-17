class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        int[] a=new int[n];
        a[0]=1;
        for(int i=1;i<n;i++){
            if( derived[i-1]==1) a[i]=a[i-1]==0?1:0;
            else a[i]=a[i-1];
        }
        if((derived[n-1]==0&&a[0]==a[n-1])||(derived[n-1]==1&&a[0]!=a[n-1])) return true;
        return false;
    }
}
