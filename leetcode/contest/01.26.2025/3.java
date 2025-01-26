class Solution {
    public int maxFrequency(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int kfreq=0,n=nums.length;
        for(int num:nums){
            if(num==k) kfreq++;
            else set.add(num);
        }
        int max=0;
        for(int setNum:set){
            int csum=0,tempmax=0;
            for(int num:nums){
                if(num==setNum) csum++;
                if(num==k) csum--;
                if(csum<0) csum=0;
                tempmax=Math.max(tempmax,csum);
            }
            max=Math.max(max,tempmax);
        }
        return kfreq+max;
    }
}
