class Solution {
    public int mod = 1000000007;

    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();

        
        int[][] freq = new int[26][n];
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                freq[word.charAt(j) - 'a'][j]++;
            }
        }

        
        Integer[][] dp = new Integer[m][n];

        return helper(words, target, 0, 0, dp, freq);
    }

    public int helper(String[] words, String target, int ti, int start, Integer[][] dp, int[][] freq) {
        
        if (ti == target.length()) {
            return 1;
        }
        
        
        if (start == words[0].length()) {
            return 0;
        }

        
        if (dp[ti][start] != null) {
            return dp[ti][start];
        }

        long count = 0;

        
        count += helper(words, target, ti, start + 1, dp, freq);

        
        char c = target.charAt(ti);
        if (freq[c - 'a'][start] > 0) {
            count += (long) freq[c - 'a'][start] * helper(words, target, ti + 1, start + 1, dp, freq);
            count %= mod;
        }

       
        dp[ti][start] = (int) (count % mod);

        return dp[ti][start];
    }
}
