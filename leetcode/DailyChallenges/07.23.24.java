class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int num:nums) m.put(num,m.getOrDefault(num,0)+1);
        Integer[] dummy=new Integer[nums.length];
        for(int i=0;i<nums.length;i++) dummy[i]=nums[i];
        Arrays.sort(dummy,(a,b)->{
            if(m.get(a)==m.get(b)) return b-a;
            return m.get(a)-m.get(b);
        });
        for(int i=0;i<nums.length;i++) nums[i]=(int)dummy[i];
        return nums;
    }
}
