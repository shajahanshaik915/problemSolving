class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> m=new HashMap<>();
        for(String str:arr){
            m.put(str,m.getOrDefault(str,0)+1);
        }
        int count=1;
        for(String str:arr){
            if(m.get(str)!=1) continue;
            else if(count!=k){
                count++;
            }
            else{
                return str;
            }
        }
        return "";
    }
}
