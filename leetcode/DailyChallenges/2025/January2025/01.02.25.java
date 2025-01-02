class Solution {
    String vow="aeiou";
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix=new int[words.length+1];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1];
            if(helper(words[i-1])) prefix[i]++;
        }
        int[] a=new int[queries.length];
        for(int i=0;i<a.length;i++){
            int s=queries[i][0]+1,e=queries[i][1]+1;
            a[i]=prefix[e]-prefix[s-1];
        }
        return a;
    }
    public boolean helper(String s){
        if(vow.contains(""+s.charAt(0))&&vow.contains(""+s.charAt(s.length()-1))) return true;
        return false;
    }
}
