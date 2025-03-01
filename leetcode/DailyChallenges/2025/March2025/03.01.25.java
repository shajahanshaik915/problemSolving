class Solution {
    public int[] applyOperations(int[] nums) {
        List<Integer> l=new ArrayList<>();
        int i=0;
        while(i<nums.length){
            if(nums[i]==0) i++;
            else if(i+1==nums.length){
                l.add(nums[i]);
                i++;
            }
            else if(nums[i]==nums[i+1]){
                l.add(nums[i]*2);
                i+=2;
            }
            else{
                l.add(nums[i]);
                i+=1;
            }
        }
        i=0;
        while(i<l.size()){
            nums[i]=l.get(i);
            i++;
        }
        while(i<nums.length){
            nums[i]=0;
            i++;
        }
        return nums;
    }
}
