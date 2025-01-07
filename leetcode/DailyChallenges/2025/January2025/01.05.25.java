class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] prefix=new int[s.length()+1];
        for(int[] shift:shifts){
            int start=shift[0],end=shift[1],direction=shift[2];
            if(direction==1){
                prefix[start]+=1;
                prefix[end+1]-=1;
            }
            if(direction==0){
                prefix[start]-=1;
                prefix[end+1]+=1;
            }
        }
        
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+prefix[i];

        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<prefix.length-1;i++){
            char ch=s.charAt(i);
            sb.append(""+moveChar(ch,prefix[i]));
        }
        return sb.toString();
    }
    public char moveChar(char ch,int times){
        times%=26;
        return (char)('a'+((ch-'a')+times+26)%26);
    }
}
