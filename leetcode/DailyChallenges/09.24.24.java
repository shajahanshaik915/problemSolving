class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();
        for(int a:arr1){
            while(!set.contains(a)&&a>0){
                set.add(a);
                a/=10;
            }
        }
        int max=0;
        for(int a:arr2){
            while(!set.contains(a)&&a>0){
                a/=10;
            }
            if(a!=0){
                max=Math.max(max,(""+a).length());
            }
        }
        return max;
    }
}
