class Solution {
    public int maximumGain(String s, int x, int y) {
        int count=0;
        String highPriority=x>y?"ab":"ba",lowPriority=x>y?"ba":"ab";
        String afterFirstOperation=helper(s,highPriority);
        count+=((s.length()-afterFirstOperation.length())/2)*Math.max(x,y);

        String afterSecondOperation=helper(afterFirstOperation,lowPriority);
        count+=((afterFirstOperation.length()-afterSecondOperation.length())/2)*Math.min(x,y);
        return count;
    }
    public static String helper(String s,String priority){
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(stack.isEmpty()||(""+stack.peek()+ch).equals(priority)==false){
                stack.push(ch);
            }
            else stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(stack.size()>0) sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}
