class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set=new HashSet<>();
        int count=0,a=0,actual=0,num=1;
        for(int[] c:grid){
            for(int d:c){
                if(set.contains(d)) a=d;
                set.add(d);
                count+=d;
                actual+=num;
                num++;
            }
        }
        
        return new int[]{a,actual-count+a};
    }
}
