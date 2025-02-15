class Solution {
    public int punishmentNumber(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(check(""+i*i,i,0)){
                count+=i*i;
            }
        }
        
        return count;
    }
    public boolean check(String s,int target,int current){
        
        if(s.length()==0) return current==target;
        for(int i=0;i<s.length();i++){
            int val=Integer.parseInt(s.substring(0,i+1));
            if(check(s.substring(i+1),target,current+val)) return true;
        }   
        return false;
    }
}
