class Solution {
    public int minimumLength(String s) {
        int count=0;
        Map<Character,Integer> m=new HashMap<>();
        for(char ch:s.toCharArray()) m.put(ch,m.getOrDefault(ch,0)+1);
        for(char ch:m.keySet()){
            if(m.get(ch)%2==1) count++;
            else count+=2;
        }
        return count;
    }
}
