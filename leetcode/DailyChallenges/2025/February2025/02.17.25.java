class Solution {
    Set<String> set;
    boolean[] used;
    public int numTilePossibilities(String tiles) {
        set=new HashSet<>();
        used=new boolean[tiles.length()];
        helper(tiles.toCharArray(),"");
        return set.size()-1;
    }
    public void helper(char[] arr,String s){
        set.add(s);
        for(int i=0;i<arr.length;i++){
            if(used[i]) continue;
            used[i]=true;
            helper(arr,s+arr[i]);
            used[i]=false;
        }
    }
    
}
