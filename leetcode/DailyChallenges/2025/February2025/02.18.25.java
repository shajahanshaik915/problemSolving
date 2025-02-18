class Solution {
    public String ans;
    public boolean[] used;
    public String smallestNumber(String pattern) {
        ans="";
        used=new boolean[10];
        for(int i=1;i<=9;i++){
            used[i]=true;
            if(helper(pattern.toCharArray(),0,""+i,i)) return ans;
            used[i]=false;
        }
        return ans;
    }
    public boolean helper(char[] arr,int index,String cur,int prev){
        if(index>=arr.length){
            ans=cur;
            return true;
        }
        if(arr[index]=='I'){
            for(int i=1;i<=9;i++){
                if(i>prev&&used[i]==false){
                    used[i]=true;
                    if(helper(arr, index+1,cur+i,i)) return true;
                    used[i]=false;
                }
            }
        }
        else{
            for(int i=1;i<=9;i++){
                if(i<prev&&used[i]==false){
                    used[i]=true;
                    if(helper(arr, index+1,cur+i,i)) return true;
                    used[i]=false;
                }
            }
        }
        return false;
    }
}
