class Solution {
    public int nthUglyNumber(int n) {
        int[] primes=new int[]{2,3,5};
        PriorityQueue<Long> q=new PriorityQueue<>();
        Set<Long> visited=new HashSet<>();
        q.add(1L);
        visited.add(1L);
        long cur=1;
        for(int i=1;i<=n;i++){
            cur=q.poll();
            for(int prime:primes){
                long newNum=prime*cur;
                if(visited.contains(newNum)) continue;
                visited.add(newNum);
                q.add(newNum);
            }
        }
        return (int)cur;
    }
}
