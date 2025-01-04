class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int count = 0;
        
        
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) first[ch] = i;
            last[ch] = i;
        }
        
        
        for (int ch = 0; ch < 26; ch++) {
            if (first[ch] != -1 && last[ch] > first[ch]) {
                Set<Character> uniqueChars = new HashSet<>();
                for (int i = first[ch] + 1; i < last[ch]; i++) {
                    uniqueChars.add(s.charAt(i));
                }
                count += uniqueChars.size();
            }
        }
        
        return count;
    }
}
