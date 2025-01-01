class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max=Integer.MIN_VALUE;
        int p=values[0];
        for(int i=1;i<values.length;i++){
            max=Math.max(p+values[i]-i,max);
            p=Math.max(p,values[i]+i);
        }
        return max;
    }
}
