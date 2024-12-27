class Solution {
    public int islands;
    public Set<int[]> visited;
    public int removeStones(int[][] stones) {
        visited=new HashSet<>();
        islands=0;
        for(int[] stone:stones){
            if(!visited.contains(stone)){
                helper(stone,stones);
                islands++;
            }
        }
        return stones.length-islands;
    }
    public void helper(int[] a,int[][] stones){
        
        if(visited.contains(a)) return;
        
        visited.add(a);
        for(int[] stone:stones){
            if(!visited.contains(stone)&&(stone[0]==a[0]||stone[1]==a[1])){
                helper(stone,stones);
            }
        }
    }
}
