class Solution {
    public int[] countMentions(int n, List<List<String>> events) {
        Collections.sort(events,(a,b)->{
            if (Integer.parseInt(a.get(1)) == Integer.parseInt(b.get(1))) {
    if (a.get(0).equals("OFFLINE") && !b.get(0).equals("OFFLINE")) {
        return -1; 
    } else if (!a.get(0).equals("OFFLINE") && b.get(0).equals("OFFLINE")) {
        return 1; 
    } else {
        return a.get(0).compareTo(b.get(0)); 
    }
}
            return Integer.parseInt(a.get(1))-Integer.parseInt(b.get(1));
        });
        //System.out.println(events);
        boolean[] online=new boolean[n];
        int[] ans=new int[n];
        Arrays.fill(online,true);
        //id, online time
        Queue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(List<String> event:events){
            int time=Integer.parseInt(event.get(1));
            while(q.size()>0&&q.peek()[1]<=time){
                    int[] dummy=q.poll();
                    online[dummy[0]]=true;
                }
            if(event.get(0).equals("MESSAGE")){
                
                
                if(event.get(2).equals("ALL")){
                    for(int i=0;i<n;i++) ans[i]++;
                }
                else if(event.get(2).equals("HERE")){
                    for(int i=0;i<n;i++) if(online[i]) ans[i]++;
                }
                else{
                    List<Integer> set=new ArrayList<>();
                    String[] ids=event.get(2).split(" ");
                    for(String id:ids){
                        if(id.length()==0) continue;
                        set.add(Integer.parseInt(id.substring(2)));
                    }
                    for(int id:set) ans[id]++;
                }
            }
            else{
                
                int id=Integer.parseInt(event.get(2));
                online[id]=false;
                q.add(new int[]{id,60+time});
            }
             // for(int b:ans) System.out.print(b+" ");
             // System.out.println();
        }
        return ans;
    }
}
