class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int[] a:nums1){
            m.put(a[0],m.getOrDefault(a[0],0)+a[1]);
        }
        for(int[] a:nums2){
            m.put(a[0],m.getOrDefault(a[0],0)+a[1]);
        }
        TreeSet<Integer> set=new TreeSet<>(m.keySet());
        int[][] ans=new int[set.size()][2];
        int i=0;
        for(int id:set){
            ans[i][0]=id;
            ans[i][1]=m.get(id);
            i++;
        }
        return ans;
    }
}
