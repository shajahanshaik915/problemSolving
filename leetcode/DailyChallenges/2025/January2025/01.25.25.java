class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        Arrays.sort(a,(c,d)->c[0]-d[0]);
        int i=0,j=1;
        while(j<n&&i<n){
            while(j<n&&a[j][0]-a[j-1][0]<=limit) j++;
            List<Integer> l=new ArrayList<>();
            for(int k=i;k<j;k++) l.add(a[k][1]);
            Collections.sort(l);
            int k=0;
            while(i<j){
                nums[l.get(k++)]=a[i][0];
                i++;
            }
            j++;
        }
        return nums;

    }
}
