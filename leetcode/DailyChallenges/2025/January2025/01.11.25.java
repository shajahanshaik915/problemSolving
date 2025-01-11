class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        Map<Character,Integer> m=new HashMap<>();
        for(char ch:s.toCharArray()) m.put(ch,m.getOrDefault(ch,0)+1);
        int odd=0,even=0,n=s.length(),size=n-k+1;
        for(char ch:m.keySet()){
            int count=m.get(ch);
            if(count%2==1){
                odd++;
                count--;
            }
            even+=count;
        }
        size-=even;
        if(size<=0||(size==1&&odd>0)) return true;
        return false;
    }
}
