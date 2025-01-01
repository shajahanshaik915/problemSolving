class Solution {
    public int maxScore(String s) {
        int[] leftZero=new int[s.length()],rightOne=new int[s.length()];
        leftZero[0]=s.charAt(0)=='0'?1:0;
        for(int i=1;i<s.length();i++){
            leftZero[i]+=s.charAt(i)=='0'?1:0;
            leftZero[i]+=leftZero[i-1];
        }
        rightOne[rightOne.length-1]=0;
        for(int i=rightOne.length-2;i>=0;i--){
            rightOne[i]+=s.charAt(i+1)=='1'?1:0;
            rightOne[i]+=rightOne[i+1];
        }
        int max=0;
        for(int i=0;i<s.length()-1;i++){
            max=Math.max(max,leftZero[i]+rightOne[i]);
        }
        return max;
    }
}
