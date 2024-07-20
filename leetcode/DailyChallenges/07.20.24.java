class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] a=new int[rowSum.length][colSum.length];
        int i=0,j=0,n=a.length,m=a[0].length;
        while(i<n&&j<m){
            a[i][j]=Math.min(rowSum[i],colSum[j]);
            rowSum[i]-=a[i][j];
            colSum[j]-=a[i][j];
            
             if(rowSum[i]==0) i++;
            else j++;
        }
        return a;
    }
}
