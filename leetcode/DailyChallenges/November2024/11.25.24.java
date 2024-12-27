class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] direction={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        String start="";
        for(int[] a:board){
            for(int b:a) start+=b;
        }
        System.out.println(start);
        int steps=0;
        q.add(start);
        visited.add(start);
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                String str=q.poll();
                if(str.equals("123450")) return steps;
                int index=str.indexOf("0");
                
                for(int a:direction[index]){
                    StringBuilder sb=new StringBuilder(str);
                    char ch=sb.charAt(a);
                    sb.setCharAt(index,ch);
                    sb.setCharAt(a,'0');
                    if(!visited.contains(sb.toString())){
                        visited.add(sb.toString());
                        q.add(sb.toString());
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
