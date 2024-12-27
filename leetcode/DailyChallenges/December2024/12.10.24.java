class Solution {
    public int maximumLength(String s) {
        StringBuilder sb=new StringBuilder(s);
        int max=-1;
        int size=1,n=s.length();
        while(size<=n){
            Map<String,Integer> m=new HashMap<>();
            int i=0,j=size-1;
            while(j<n){
                String str=sb.substring(i,j+1);
                m.put(str,m.getOrDefault(str,0)+1);
                i++;
                j++;
            }
            
            for(String str:m.keySet()){
                if(helper(str)&&m.get(str)>=3) {
                    //System.out.println(str);
                    max=Math.max(max,str.length());
                    break;
                }
            }
            size++;
        }
        return max;

    }
    public boolean helper(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)) return false;
        }
        return true;
    }
}
