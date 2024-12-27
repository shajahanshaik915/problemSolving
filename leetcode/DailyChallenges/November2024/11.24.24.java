class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int min=Integer.MAX_VALUE;
        int count=0;
        for(int[] a:matrix){    
            for(int b:a){
                if(b<0) count++;
                sum+=Math.abs(b);
                min=Math.min(min,Math.abs(b));
            }
        }
        if(count%2==0) return sum;
        return sum-(2*min);
    }
}
