class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character,Integer> m=new HashMap<>();
        for(String word:words2){
            updateMap(word,m);
        }
        List<String> l=new ArrayList<>();
        for(String word:words1){
            if(check(m,word)) l.add(word);
        }
        return l;
    }
    public boolean check(Map<Character,Integer> oldMap,String s){
        Map<Character,Integer> newMap=new HashMap<>();

        for(char ch:s.toCharArray()) newMap.put(ch,newMap.getOrDefault(ch,0)+1);
        
        for(char ch:oldMap.keySet()){
            if(!newMap.containsKey(ch)||newMap.get(ch)<oldMap.get(ch)) return false;
        }
        
        return true;
    }
    public void updateMap(String word,Map<Character,Integer> m){
        Map<Character,Integer> newMap=new HashMap<>();
        for(char ch:word.toCharArray()) newMap.put(ch,newMap.getOrDefault(ch,0)+1);
        for(char ch:newMap.keySet()){
            int oldVal=m.getOrDefault(ch,0),newVal=newMap.get(ch);
            m.put(ch,Math.max(oldVal,newVal));
        }
    }
}
