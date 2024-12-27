class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Queue<Character> q=new PriorityQueue<>((a,b)->b-a);
        Map<Character,Integer> m=new HashMap<>();
        for(char ch:s.toCharArray()) m.put(ch,m.getOrDefault(ch,0)+1);
        for(char ch:m.keySet()) q.add(ch);
        StringBuilder ans=new StringBuilder();
        while(q.size()>0){
            char ch=q.poll();
            int count=m.get(ch);
            int n=count>repeatLimit?repeatLimit:count;
            for(int i=0;i<n;i++) ans.append(ch);
            
            if(count>repeatLimit){
                if(q.size()==0) return ans.toString();
                char ch2=q.poll();
                ans.append(ch2);
                m.put(ch2,m.get(ch2)-1);
                if(m.get(ch2)>0) q.add(ch2);
            }
            m.put(ch,m.get(ch)-n);
            if(m.get(ch)>0) q.add(ch);
        }
        return ans.toString();
    }
}
