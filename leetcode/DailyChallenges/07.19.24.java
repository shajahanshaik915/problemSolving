class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rowMin=Integer.MIN_VALUE;
        for(int []a:matrix){
            int min=Integer.MAX_VALUE;
            for(int b:a) min=Math.min(b,min);
            rowMin=Math.max(rowMin,min);
        }

        int colMax=Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<matrix.length;i++){
                max=Math.max(max,matrix[i][j]);
            }
            colMax=Math.min(colMax,max);
        }
        List<Integer> l=new ArrayList<>();
        if(rowMin==colMax) l.add(rowMin);
        return l;
    }
}
