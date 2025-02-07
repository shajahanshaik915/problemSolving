class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans=new int[queries.length];
        Map<Integer,Integer> ballColor=new HashMap<>();
        Map<Integer,Integer> colorCount=new HashMap<>();
        int index=0;
        for(int[] query:queries){
            int x=query[0],y=query[1];
            if(ballColor.containsKey(x)){
                int previousColor=ballColor.get(x);
                colorCount.put(previousColor,colorCount.get(previousColor)-1);
                if(colorCount.get(previousColor)==0) colorCount.remove(previousColor);

            }
            ballColor.put(x,y);
            colorCount.put(y,colorCount.getOrDefault(y,0)+1);
            ans[index++]=colorCount.keySet().size();
        }
        return ans;
    }
}
