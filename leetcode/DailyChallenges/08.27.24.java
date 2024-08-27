class Solution {
    class pair{
        int val;
        double prob;
        pair(int val,double prob){
            this.val=val;
            this.prob=prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer,List<pair>> m=new HashMap<>();
        for(int i=0;i<n;i++) m.put(i,new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0],b=edges[i][1];
            m.get(a).add(new pair(b,succProb[i]));
            m.get(b).add(new pair(a,succProb[i]));
        }
        double[] currentProb=new double[n];
        Queue<pair> q=new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        q.add(new pair(start_node,1));
        currentProb[start_node]=1;
        while(q.size()>0){
            pair node=q.poll();
            int nodeVal=node.val;
            double nodeProb=node.prob;
            if(nodeVal==end_node) return nodeProb;
            for(pair adjPair:m.get(nodeVal)){
                int adjPairVal=adjPair.val;
                double adjPairProb=adjPair.prob;
                double newProb=nodeProb*adjPairProb;
                System.out.println(newProb);
                if(newProb>currentProb[adjPairVal]){
                    currentProb[adjPairVal]=newProb;
                    q.add(new pair(adjPairVal,newProb));
                }
            }
        }
        return 0;
    }
}
