import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int index = 0;

        while (index < formula.length()) {
            if (formula.charAt(index) == '(') {
                stack.push(new HashMap<>());
                index++;
            } else if (formula.charAt(index) == ')') {
                Map<String, Integer> top = stack.pop();
                index++;
                StringBuilder sb = new StringBuilder();
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    sb.append(formula.charAt(index));
                    index++;
                }
                int multiplier = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                for (String key : top.keySet()) {
                    top.put(key, top.get(key) * multiplier);
                }
                for (String key : top.keySet()) {
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + top.get(key));
                }
            } else {
                StringBuilder atom = new StringBuilder();
                atom.append(formula.charAt(index++));
                while (index < formula.length() && Character.isLowerCase(formula.charAt(index))) {
                    atom.append(formula.charAt(index++));
                }
                StringBuilder sb = new StringBuilder();
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    sb.append(formula.charAt(index++));
                }
                int count = sb.length() > 0 ? Integer.parseInt(sb.toString()) : 1;
                stack.peek().put(atom.toString(), stack.peek().getOrDefault(atom.toString(), 0) + count);
            }
        }

        TreeMap<String, Integer> result = new TreeMap<>(stack.peek());
        StringBuilder output = new StringBuilder();
        for (String atom : result.keySet()) {
            output.append(atom);
            if (result.get(atom) > 1) {
                output.append(result.get(atom));
            }
        }

        return output.toString();
    }
}
