class Solution {
    public String largestNumber(int[] nums1) {
        Integer[] nums=Arrays.stream(nums1).boxed().toArray(Integer[]::new);

        Arrays.sort(nums,(a,b)->{
            String s1=""+a+b,s2=""+b+a;
            return s2.compareTo(s1);
        });

        if(nums[0]==0) return "0";
        String ans="";
        for(int a:nums) ans+=a;
        return ans;
    }
}
