class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
       Queue<double[]> q=new PriorityQueue<>((a,b)->{
        return Double.compare(b[2],a[2]);
       });
       for(int[] a:classes){
        double pass=(double)a[0],total=(double)(a[1]);
        double diff=helper(pass,total);
        q.add(new double[]{pass,total,diff});
       }
       while(extraStudents-->0){
        double[] a=q.poll();
        a[0]++;
        a[1]++;
        q.add(new double[]{a[0],a[1],helper(a[0],a[1])});
       }
       
       double total=0;
       while(q.size()>0){
        double[] a=q.poll();
        total+=a[0]/a[1];
       }
       return total/classes.length;
    }
    public double helper(double pass,double total){
        double pp=pass/total;
        double np=pass+1,nt=total+1;
        double npp=np/nt;
        return npp-pp;
    }
}
