class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        int count=0;
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            freq1[ch1-'a']++;
            freq2[ch2-'a']++;
            if(ch1!=ch2) count++;
            if(count>2) return false;
        }
        for(int i=0;i<26;i++) if(freq1[i]!=freq2[i]) return false;
        return count==2||count==0;
    }
}
