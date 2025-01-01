class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> m=new HashMap<>();
        for(String s:s1.split(" ")){
            m.put(s,m.getOrDefault(s,0)+1);
        }
        for(String s:s2.split(" ")){
            m.put(s,m.getOrDefault(s,0)+1);
        }
        int count=0;
        for(String s:m.keySet()){
            if(m.get(s)==1) count++;
        }
        String[] ans=new String[count];
        int i=0;
        for(String s:m.keySet()){
            if(m.get(s)==1){
                ans[i++]=s;
            }
        }
        return ans;
    }
}
