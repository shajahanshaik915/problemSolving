class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row=helper(k,rowConditions),col=helper(k,colConditions);
        if(row.size()==0||row.size()!=col.size()) return new int[][]{};
        int[][] arr=new int[k][k];
        for(int i=0;i<row.size();i++){
            int a=row.get(i),index=col.indexOf(a);
            arr[i][index]=a;
        }
        return arr;
    }
    public static List<Integer> helper(int k,int[][] conditions){
        List<Integer> answer=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        Map<Integer,Set<Integer>> m=new HashMap<>();
        int[] prereq=new int[k+1];
        for(int[] condition:conditions){
            int upper=condition[0],lower=condition[1];
            
            m.putIfAbsent(upper,new HashSet<>());
            if(!m.get(upper).contains(lower)){
                m.get(upper).add(lower);
                prereq[lower]++;
            }
        }
        
        for(int i=1;i<prereq.length;i++){
            if(prereq[i]==0){
                q.add(i);
                answer.add(i);
            }
            
        }
        
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int course=q.poll();
                if(!m.containsKey(course)) continue;
                for(int a:m.get(course)){
                    if(answer.contains(a)) continue;
                    prereq[a]--;
                    if(prereq[a]==0){
                        answer.add(a);
                        q.add(a);
                    }
                }
            }
        }
        
        
        return answer;
    }
}
