class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] d=new int[1001];
        for(int a:target) d[a]++;
        for(int a:arr){
            d[a]--;
            if(d[a]<0) return false;
        }
        return true;
    }
}
