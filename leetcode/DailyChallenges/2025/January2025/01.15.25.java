class Solution {
    public int minimizeXor(int num1, int num2) {
        int a=Integer.bitCount(num1),b=Integer.bitCount(num2);
        //System.out.println(a+" "+b);
        if(a==b) return num1;
        // first Make All ones Match....
        String bnr=Integer.toBinaryString(num1);
        if(a>b){
            StringBuilder one=new StringBuilder(bnr);
        for(int i=0;i<one.length();i++){
            if(b<=0) break;
            char ch=one.charAt(i);
            if(ch=='1'){
                one.setCharAt(i,'2');
                b--;
            }
        }
        
            String ans="";
            for(int i=0;i<one.length();i++){
                char ch=one.charAt(i);
                if(ch=='2') ans+="1";
                else ans+="0";
            }
            return Integer.parseInt(ans,2);
        }
        else if(b>bnr.length()){
            String s="";
            while(b-->0) s+="1";
            return Integer.parseInt(s,2);
        }
        else{
            b-=a;
            StringBuilder ans=new StringBuilder(bnr);
            //System.out.println(ans);
            for(int i=ans.length()-1;i>=0;i--){
                if(b<=0) break;
                if(ans.charAt(i)=='0'){
                    ans.setCharAt(i,'1');
                    b--;
                }
            }
            return Integer.parseInt(ans.toString(),2);
        }
        
        
    }
}
