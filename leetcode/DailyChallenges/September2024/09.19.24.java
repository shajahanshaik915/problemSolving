class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> l=new ArrayList<>();
        int n=expression.length();
        for(int i=0;i<n;i++){
            char ch=expression.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'){
                List<Integer> l1=diffWaysToCompute(expression.substring(0,i));
                List<Integer> l2=diffWaysToCompute(expression.substring(i+1,n));
                for(int a:l1){
                    for(int b:l2){
                        if(ch=='+') l.add(a+b);
                        else if(ch=='-') l.add(a-b);
                        else if(ch=='*') l.add(a*b);
                    }
                }
            }
        }
        if(l.size()==0) l.add(Integer.parseInt(expression));
        return l;
    }
}
