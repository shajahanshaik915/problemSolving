class Solution {
    List<String> l;
    public List<String> generateParenthesis(int n) {
        l=new ArrayList<>();
        helper(n,0,0,new StringBuilder());
        return l;
    }
    public void helper(int n,int copen,int topen,StringBuilder current){
        if(current.length()==2*n){
            l.add(current.toString());
            return;
        }
        if(topen<n){
            current.append("(");
            helper(n,copen+1,topen+1,current);
            current.deleteCharAt(current.length()-1);
        }
        if(copen>0){
            current.append(")");
            helper(n,copen-1,topen,current);
            current.deleteCharAt(current.length()-1);
        }
    }
}
