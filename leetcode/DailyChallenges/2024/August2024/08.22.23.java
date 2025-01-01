class Solution {
    public int findComplement(int num) {
        String str=Integer.toBinaryString(num);
        int sum=0;
        int power=0;
        for(int i=str.length()-1;i>=0;i--){
            int val=str.charAt(i)=='0'?1:0;
            sum+=val*(int)Math.pow(2,power);
            power++;
        }
        return sum;
    }
}
