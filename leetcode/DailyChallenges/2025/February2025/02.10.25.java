class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                if(stack.size()>0) stack.pop();
            }
            else stack.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(stack.size()>0){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
