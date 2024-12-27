class Solution {
    public int maxUniqueSplit(String s) {
        return helper(s,"",new HashSet<>());
    }
    public int helper(String s,String prev,HashSet<String> set){
        if(s.length()==0){
            if(prev.length()>0&&set.contains(prev)==false) return set.size()+1;
            return set.size();
        }
        
        // Option One is to Join Prev String
        int max=0;
        max=Math.max(helper(s.substring(1),prev+s.charAt(0),set),max);
        if(prev.length()>0&&!set.contains(prev)){
            HashSet<String> newSet=new HashSet<>(set);
            newSet.add(prev);
            max=Math.max(max,helper(s.substring(1),""+s.charAt(0),newSet));
        }
        return max;
    }
}
