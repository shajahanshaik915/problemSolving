class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {

        String res = lcs(str1, str2, 0, 0, new String[str1.length() + 1][str2.length() + 1]);
        String ans = "";
        int index = 0, i = 0, j = 0;
        while (index < res.length()) {
            char ch = res.charAt(index);
            while (i < str1.length() && str1.charAt(i) != ch) {
                ans += str1.charAt(i);
                i++;
            }
            while (j < str2.length() && str2.charAt(j) != ch) {
                ans += str2.charAt(j);
                j++;
            }
            ans += ch;
            index++;
            i++;
            j++;
        }
        while (i < str1.length()) {
            ans += str1.charAt(i);
            i++;
        }
        while (j < str2.length()) {
            ans += str2.charAt(j);
            j++;
        }
        return ans;
    }
    public String lcs(String s1,String s2,int i,int j,String[][] dp){
        if(i>=s1.length()||j>=s2.length()){
            return "";
        }
        if(dp[i][j]!=null) return dp[i][j];
        String res;
        if(s1.charAt(i)==s2.charAt(j)){
            res=s1.charAt(i)+lcs(s1,s2,i+1,j+1,dp);
        }
        else{
            String option1=lcs(s1,s2,i+1,j,dp);
            String option2=lcs(s1,s2,i,j+1,dp);
            res=option1.length()>option2.length()?option1:option2;
        }
        return dp[i][j]=res;
    }
}
