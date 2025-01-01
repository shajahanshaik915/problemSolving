class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> q=new PriorityQueue<>((a,b)->b-a);
        for(int gift:gifts) q.add(gift);
        while(k-->0&&q.size()>0){
            int gift=q.poll();
            int sqrt=(int)Math.floor(Math.sqrt(gift));
            if(sqrt!=0) q.add(sqrt);
        }
        long sum=0;
        while(q.size()>0) sum+=q.poll();
        return sum;
    }
}
