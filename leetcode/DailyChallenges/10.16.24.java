class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> q=new PriorityQueue<>((k,g)->{
            return g[1]-k[1];
        });
        String result="";
        if(a>0) q.add(new int[]{0,a});
        if(b>0) q.add(new int[]{1,b});
        if(c>0) q.add(new int[]{2,c});
        while(q.size()>0){
            int[] arr=q.poll();
            char ch=(char)(arr[0]+'a');
            if(result.length()>1&&result.charAt(result.length()-2)==ch&&result.charAt(result.length()-1)==ch){
                if(q.size()==0) return result;
                int[] arr2=q.poll();
                char ch2=(char)(arr2[0]+'a');
                result+=ch2;
                arr2[1]--;
                if(arr2[1]>0) q.add(arr2);
                q.add(arr);
            }
            else{
                arr[1]--;
                result+=ch;
                if(arr[1]>0) q.add(arr);
            }
        }
        return result;
    }
}
