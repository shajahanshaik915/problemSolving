class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0,n=words.length;
        for(int i=0;i<n;i++){
            String a=words[i];
            for(int j=i+1;j<n;j++){
                String b=words[j];
                if(b.startsWith(a)&&b.endsWith(a)) count++;
            }
        }
        return count;
    }
}
