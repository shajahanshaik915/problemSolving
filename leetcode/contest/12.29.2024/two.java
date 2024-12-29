class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1) return word;
        int index=0;
        char ch='a';
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>ch){
                ch=c;
                index=i;
            }
        }
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch) l.add(i);
        }
        String ans="a";
        for(int i:l){
            String res=helper(word,numFriends,i);
            if(ans.compareTo(res)<0){
                ans=res;
            }
        }
        return ans;
    }
    public String helper(String word,int n,int index){
        int numFriends=n;
        numFriends--;
        numFriends-=index;
        int j=index+1;
        while(j<word.length()&&word.length()-j>numFriends){
            j++;
        }
        return word.substring(index,j);
    }
    
}
