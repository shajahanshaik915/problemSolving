class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int prod=nums[i]*nums[j];
                m.put(prod,m.getOrDefault(prod,0)+1);
            }
        }
        int count=0;
        for(int prod:m.keySet()){
            int freq=m.get(prod);
            if(freq>1){
                count+=(freq*(freq-1))*4;
            }
        }
        return count;
    }
}
