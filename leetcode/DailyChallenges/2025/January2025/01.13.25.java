class Solution {
    public int minimumLength(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()) freq[ch-'a']++;
        int count=0;
        for(int a:freq){
            if(a==0) continue;
            if(a%2==0) count+=2;
            else count+=1;
        }
        return count;
    }
}
