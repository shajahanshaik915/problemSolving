class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2==1) return false;
        Stack<Integer> open=new Stack<>(),unLocked=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i),lock=locked.charAt(i);
            if(lock=='0') unLocked.push(i);
            else if(ch=='(') open.push(i);
            else{
                if(open.size()>0) open.pop();
                else if(unLocked.size()>0) unLocked.pop();
                else return false;
            }
        }
        while(open.size()>0){
            if(unLocked.size()==0||unLocked.peek()<open.peek()) return false;
            unLocked.pop();
            open.pop();
        }
        return true;
    }
}
