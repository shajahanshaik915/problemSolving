class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words,(a,b)->b.length()-a.length());
        Set<String> set=new HashSet<>();
        List<String> l=new ArrayList<>();
        for(String word:words){
            for(String s:set){
                if(s.contains(word)){
                    l.add(word);
                    break;
                }
            }
            set.add(word);
        }
        return l;
    }
}
