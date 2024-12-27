class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            m.put(ch,m.getOrDefault(ch,0)+1);
        }
        Queue<Character> pq=new PriorityQueue<>((a,b)->m.get(b)-m.get(a));
        for(char ch:m.keySet()){
            pq.add(ch);
        }
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=2;i<=9;i++) q.add(1);
        while(pq.size()>0){
            int val=q.poll();
            count+=m.get(pq.poll())*val;
            q.add(val+1);
        }
        return count;
    }
}
