class Solution {
    public String shortestPalindrome(String s) {
        //   01234567      
        // s=aacecaaa
        // r=aaacecaa
        //    i

        String r=new StringBuilder(s).reverse().toString();
        for(int i=0;i<s.length();i++){
            if(s.substring(0,s.length()-i).equals(r.substring(i))){
                return ""+r.substring(0,i)+s;
            }
        }
        return "";
    }
}
