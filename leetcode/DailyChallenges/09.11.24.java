class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        while(start>0||goal>0){
            boolean one=((start&1)==1),two=((goal&1)==1);
            if(one!=two) count++;
            start=start>>1;
            goal=goal>>1;
        }
        return count;
    }
}
