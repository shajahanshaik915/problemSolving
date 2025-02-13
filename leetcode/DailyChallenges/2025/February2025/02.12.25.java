class Solution {
    public int maximumSum(int[] nums) {
        int ans=-1;
        Map<Integer,Integer> m=new HashMap<>();
        for(int num:nums){
            int sum=digitSum(num);
            if(m.containsKey(sum)){
                ans=Math.max(ans,m.get(sum)+num);
            }
            m.put(sum,Math.max(m.getOrDefault(sum,0),num));
        }
        return ans;
    }
    public int digitSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
