class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] prereq=new int[numCourses];
        Map<Integer,Set<Integer>> m=new HashMap<>();
        for(int i=0;i<numCourses;i++) m.put(i,new HashSet<>());
        for(int[] prerequisite:prerequisites){
            int a=prerequisite[0],b=prerequisite[1];
            m.get(a).add(b);
            prereq[b]++;
        }
        Map<Integer,Set<Integer>> mp=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(prereq[i]==0){
                q.add(i);
                mp.put(i,new HashSet<>());
            }
        }
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int course=q.poll();
                for(int nextCourse:m.get(course)){
                    prereq[nextCourse]--;
                    mp.putIfAbsent(nextCourse,new HashSet<>());
                    mp.get(nextCourse).add(course);
                    mp.get(nextCourse).addAll(mp.get(course));
                    if(prereq[nextCourse]==0){
                        q.add(nextCourse);

                    }
                }
            }
        }
        //System.out.println(mp);
        List<Boolean> l=new ArrayList<>();
        for(int[] query:queries){
            l.add(mp.get(query[1]).contains(query[0])?true:false);
        }
        
        return l;
    }
}
