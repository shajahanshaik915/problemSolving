class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> q=new PriorityQueue<>();
        for(int num:nums) q.add((long)num);
        int count=0;
        while(q.peek()<k){
            long val=q.poll()*2+q.poll();
            q.add(val);
            count++;
        }
        return count;
    }
}
