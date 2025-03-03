class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> before=new ArrayList<>();
        List<Integer> after=new ArrayList<>();
        int p=0;
        for(int num:nums){
            if(num>pivot) after.add(num);
            else if(num<pivot) before.add(num);
            else p++;
        }
        int i=0;
        for(int a:before) nums[i++]=a;
        while(p-->0) nums[i++]=pivot;
        for(int a:after) nums[i++]=a;
        return nums;
    }
}
