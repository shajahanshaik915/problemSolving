class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] ch = blocks.toCharArray();
        int i = 0, j = 0, w = 0, b = 0;
        int ans = k;
        while (j < ch.length) {
            while (j - i + 1 < k) {
                if (ch[j] == 'W')
                    w++;
                else
                    b++;
                j++;
            }

            if (ch[j] == 'W')
                w++;
            else
                b++;
            ans = Math.min(ans, w);
            if (ch[i] == 'W')
                w--;
            else
                b--;
            i++;
            j++;
        }
        return ans;
    }
}
