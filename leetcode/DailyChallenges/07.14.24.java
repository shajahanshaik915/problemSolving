class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> stack=new Stack<>();
        int index=0;
        stack.push(new HashMap<>());
        while(index<formula.length()){            
            if(formula.charAt(index)=='('){
                stack.push(new HashMap<>());
                index++;
            }
            else if(formula.charAt(index)==')'){
                StringBuilder sb=new StringBuilder();
                index++;
                while(index<formula.length()&&Character.isDigit(formula.charAt(index))){
                    sb.append(formula.charAt(index));
                    index++;
                }
                int multiply=sb.length()==0?1:Integer.parseInt(sb.toString());
                Map<String,Integer> m=stack.pop();
                if(stack.isEmpty()) stack.push(new HashMap<>());
                for(String str:m.keySet()){
                    stack.peek().put(str,stack.peek().getOrDefault(str,0)+(m.get(str)*multiply));
                }
            }
            else{
                String atom="";
                atom+=formula.charAt(index);
                index++;
                while(index<formula.length()&&Character.isLowerCase(formula.charAt(index))){
                    atom+=formula.charAt(index);
                    index++;
                }
                String number="";
                while(index<formula.length()&&Character.isDigit(formula.charAt(index))){
                    number+=formula.charAt(index);
                    index++;
                }
                int multiply=number.length()>0?Integer.parseInt(number):1;
                stack.peek().put(atom,stack.peek().getOrDefault(atom,0)+multiply);
            }
        }
        TreeMap<String,Integer> tm=new TreeMap<>(stack.peek());
        String ans="";
        for(String str:tm.keySet()){
            ans+=str;
            if(tm.get(str)>1) ans+=tm.get(str);
        }
        return ans;
    }
}
