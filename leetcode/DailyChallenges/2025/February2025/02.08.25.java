class NumberContainers {
    Map<Integer,Integer> indexvalue;
    Map<Integer,PriorityQueue<Integer>> valueindex;
    public NumberContainers() {
        this.indexvalue=new HashMap<>();
        this.valueindex=new HashMap<>();
    }
    
    public void change(int index, int number) {
        indexvalue.put(index,number);
        if(!valueindex.containsKey(number)){
            valueindex.put(number,new PriorityQueue<>());
        }
        valueindex.get(number).add(index);
    }
    
    public int find(int number) {
        if(!valueindex.containsKey(number)) return -1;
        PriorityQueue<Integer> q=valueindex.get(number);
        while(q.size()>0&&indexvalue.get(q.peek())!=number){
            q.poll();
        }
        if(q.size()>0) return q.peek();
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
