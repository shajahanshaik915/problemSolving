class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[n];
        ans[n-1]=prices[n-1];
        stack.push(prices[n-1]);
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0&&stack.peek()>prices[i]) stack.pop();
            ans[i]=stack.size()>0?prices[i]-stack.peek():prices[i];
            stack.push(prices[i]);
        }
        return ans;
    }
}
