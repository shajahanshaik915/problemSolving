class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str=sentence.split(" ");
        int i=0;
        for(String s:str){
            if(s.startsWith(searchWord)) return i+1;
            i++;
        }
        return -1;
    }
}
